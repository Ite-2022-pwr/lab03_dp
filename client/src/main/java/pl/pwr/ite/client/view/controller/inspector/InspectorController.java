package pl.pwr.ite.client.view.controller.inspector;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.springframework.http.HttpMethod;
import pl.pwr.ite.client.model.dto.RegistrationDto;
import pl.pwr.ite.client.model.dto.ReportDto;
import pl.pwr.ite.client.model.dto.TreeDto;
import pl.pwr.ite.client.model.enums.RegistrationStatus;
import pl.pwr.ite.client.model.filter.RegistrationFilter;
import pl.pwr.ite.client.model.filter.TreeFilter;
import pl.pwr.ite.client.service.SceneManager;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.view.model.ManagerRegistrationTableDataModel;
import pl.pwr.ite.client.view.model.TreeTableDataModel;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InspectorController {
    private final SceneManager sceneManager = SceneManager.getInstance();
    private final WebClientService webClientService = WebClientService.getInstance();
    private RegistrationDto selectedRegistration;
    @FXML protected TextArea reportDescriptionTextArea;
    @FXML protected Label reportLabel;
    @FXML protected TableView<TreeTableDataModel> treesTableView;
    @FXML protected Label statusLabel;
    @FXML protected Label userIdLabel;
    @FXML protected Label timeLabel;
    @FXML protected Label idLabel;
    @FXML protected TableView<ManagerRegistrationTableDataModel> registrationsTableView;

    @FXML
    protected void refreshButtonClick(ActionEvent event) {
        var registrationDto = new RegistrationDto();
        registrationDto.setUser(sceneManager.getUserContext());
        var filter = new RegistrationFilter();
        filter.setStatuses(new RegistrationStatus[] { RegistrationStatus.RequiresReport });
        var data = webClientService.sendRequest(HttpMethod.GET, "/registration/list", filter, RegistrationFilter.class, RegistrationDto[].class);
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
        statusLabel.setText(registration.getStatus().toString());
        treesTableView.setItems(FXCollections.observableList(Arrays.stream(registration.getTrees()).map(TreeTableDataModel::new).collect(Collectors.toList())));
    }

    public void saveReportButtonClick(ActionEvent event) {
        if(selectedRegistration == null) {
            return;
        }
        selectedRegistration.setStatus(RegistrationStatus.Pending);
        webClientService.sendRequest(HttpMethod.PUT, "/registration", selectedRegistration, RegistrationDto.class, RegistrationDto.class);

        var report = new ReportDto();
        report.setRegistration(selectedRegistration);
        report.setDescription(reportDescriptionTextArea.getText());
        report.setUser(sceneManager.getUserContext());
        webClientService.sendRequest(HttpMethod.POST, "/report", report, ReportDto.class, ReportDto.class);
        selectedRegistration = null;
        clear();
        refreshButtonClick(null);
    }

    private void clear() {
        idLabel.setText("");
        userIdLabel.setText("");
        timeLabel.setText("");
        statusLabel.setText("");
        treesTableView.getItems().clear();
        reportDescriptionTextArea.setText("");
    }
}
