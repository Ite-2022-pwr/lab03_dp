package pl.pwr.ite.client.view.controller.manager;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.springframework.http.HttpMethod;
import pl.pwr.ite.client.model.dto.DecisionDto;
import pl.pwr.ite.client.model.dto.RegistrationDto;
import pl.pwr.ite.client.model.dto.ReportDto;
import pl.pwr.ite.client.model.dto.TreeDto;
import pl.pwr.ite.client.model.enums.RegistrationStatus;
import pl.pwr.ite.client.model.filter.DecisionFilter;
import pl.pwr.ite.client.model.filter.ReportFilter;
import pl.pwr.ite.client.model.filter.TreeFilter;
import pl.pwr.ite.client.service.SceneManager;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.view.model.TreeTableDataModel;
import pl.pwr.ite.client.view.model.ManagerRegistrationTableDataModel;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ManagerController {
    private final SceneManager sceneManager = SceneManager.getInstance();
    private final WebClientService webClientService = WebClientService.getInstance();
    private RegistrationDto selectedRegistration;
    @FXML protected Label reportDescriptionLabel;
    @FXML protected Label reportLabel;
    @FXML protected TableView<TreeTableDataModel> treesTableView;
    @FXML protected Label decisionLabel;
    @FXML protected ComboBox<RegistrationStatus> statusComboBox;
    @FXML protected Label userIdLabel;
    @FXML protected TextArea decisionTextField;
    @FXML protected Label timeLabel;
    @FXML protected Label idLabel;
    @FXML protected TableView<ManagerRegistrationTableDataModel> registrationsTableView;

    @FXML
    protected void refreshButtonClick(ActionEvent event) {
        var registrationDto = new RegistrationDto();
        registrationDto.setUser(sceneManager.getUserContext());
        var data = webClientService.sendRequest("/registration/get-all", RegistrationDto[].class);
        for(var registration : data) {
            var treeFilter = new TreeFilter();
            treeFilter.setRegistrationId(registration.getId());
            var trees = webClientService.sendRequest(HttpMethod.GET, "/tree/list", treeFilter, TreeFilter.class, TreeDto[].class);
            registration.setTrees(trees);
        }
        registrationsTableView.setItems(FXCollections.observableList(Arrays.stream(data).map(ManagerRegistrationTableDataModel::new).collect(Collectors.toList())));
    }

    @FXML
    protected void cellSelectedEvent(MouseEvent mouseEvent) {
        if(registrationsTableView.getSelectionModel().getSelectedItem() == null) {
            selectedRegistration = null;
            return;
        }
        var registration = registrationsTableView.getSelectionModel().getSelectedItem().getRegistration();
        this.selectedRegistration = registration;
        idLabel.setText(registration.getId().toString());
        userIdLabel.setText(registration.getUser().getId().toString());
        timeLabel.setText(registration.getTime().toString());
        statusComboBox.setValue(registration.getStatus());
        treesTableView.setItems(FXCollections.observableList(Arrays.stream(registration.getTrees()).map(TreeTableDataModel::new).collect(Collectors.toList())));
        if(registration.getStatus() == RegistrationStatus.Finished) {
            var filter = new DecisionFilter();
            filter.setRegistrationId(selectedRegistration.getId());
            var decision = webClientService.sendRequest(HttpMethod.GET, "/decision/get", filter, DecisionFilter.class, DecisionDto.class);
            decisionTextField.setText(decision.getDescription());
        }
        boolean shouldRenderReport =
                registration.getStatus() == RegistrationStatus.Pending
                || registration.getStatus() == RegistrationStatus.Finished;
        reportLabel.setVisible(shouldRenderReport);
        reportDescriptionLabel.setVisible(shouldRenderReport);
        if(shouldRenderReport) {
            var filter = new ReportFilter();
            filter.setRegistrationId(selectedRegistration.getId());
            var report = webClientService.sendRequest(HttpMethod.GET, "/report/get", filter, ReportFilter.class, ReportDto.class);
            reportDescriptionLabel.setText(report == null ? "Not provided" : report.getDescription());
        }
    }

    public void statusChanged(ActionEvent event) {
        var value = statusComboBox.getSelectionModel().getSelectedItem();
        boolean shouldRenderDecision = value == RegistrationStatus.Finished;
        decisionLabel.setVisible(shouldRenderDecision);
        decisionTextField.setVisible(shouldRenderDecision);
    }

    public void saveDecisionButtonClick(ActionEvent event) {
        if(selectedRegistration == null) {
            return;
        }
        selectedRegistration.setStatus(statusComboBox.getSelectionModel().getSelectedItem());
        if(selectedRegistration.getStatus() == RegistrationStatus.Finished) {
            var decision = new DecisionDto();
            decision.setUser(sceneManager.getUserContext());
            decision.setRegistration(selectedRegistration);
            decision.setDescription(decisionTextField.getText());
            webClientService.sendRequest("/decision", decision, DecisionDto.class, DecisionDto.class);
        }
        webClientService.sendRequest(HttpMethod.PUT, "/registration", selectedRegistration, RegistrationDto.class, RegistrationDto.class);
        selectedRegistration = null;
        clear();
    }

    private void clear() {
        idLabel.setText("");
        userIdLabel.setText("");
        timeLabel.setText("");
        statusComboBox.setValue(null);
        treesTableView.getItems().clear();
        reportLabel.setVisible(false);
        reportDescriptionLabel.setVisible(false);
        decisionLabel.setVisible(false);
        decisionTextField.setVisible(false);
    }
}
