package pl.pwr.ite.client.view.controller.citizen;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.springframework.http.HttpMethod;
import pl.pwr.ite.client.model.dto.DecisionDto;
import pl.pwr.ite.client.model.dto.RegistrationDto;
import pl.pwr.ite.client.model.dto.TreeDto;
import pl.pwr.ite.client.model.enums.RegistrationStatus;
import pl.pwr.ite.client.model.filter.DecisionFilter;
import pl.pwr.ite.client.model.filter.RegistrationFilter;
import pl.pwr.ite.client.model.filter.TreeFilter;
import pl.pwr.ite.client.service.SceneManager;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.view.model.CitizenRegistrationTableDataModel;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ListRegistrationsController {
    private final SceneManager sceneManager = SceneManager.getInstance();
    private final WebClientService webClientService = WebClientService.getInstance();
    @FXML protected Label decisionLabel;
    @FXML protected Label totalTreesLabel;
    @FXML protected Label timeLabel;
    @FXML protected Label statusLabel;
    @FXML protected Label idLabel;
    @FXML protected TableView<CitizenRegistrationTableDataModel> registrationsTableView;

    @FXML
    protected void refreshButtonClick(ActionEvent event) {
        var registrationDto = new RegistrationDto();
        registrationDto.setUser(sceneManager.getUserContext());
        var filter = new RegistrationFilter();
        filter.setUserId(sceneManager.getUserContext().getId());
        filter.setStatuses(new RegistrationStatus[]{ RegistrationStatus.New, RegistrationStatus.Pending, RegistrationStatus.Finished, RegistrationStatus.RequiresReport });
        var data = webClientService.sendRequest(HttpMethod.GET, "/registration/list", filter, RegistrationFilter.class, RegistrationDto[].class);
        for(var registration : data) {
            var treeFilter = new TreeFilter();
            treeFilter.setRegistrationId(registration.getId());
            var trees = webClientService.sendRequest(HttpMethod.GET, "/tree/list", treeFilter, TreeFilter.class, TreeDto[].class);
            registration.setTrees(trees);
        }
        registrationsTableView.setItems(FXCollections.observableList(Arrays.stream(data).map(CitizenRegistrationTableDataModel::new).collect(Collectors.toList())));
    }

    @FXML
    protected void cellSelectedEvent(MouseEvent mouseEvent) {
        if(registrationsTableView.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        var selectedRegistration = registrationsTableView.getSelectionModel().getSelectedItem().getRegistration();
        idLabel.setText(selectedRegistration.getId().toString());
        statusLabel.setText(selectedRegistration.getStatus().toString());
        timeLabel.setText(selectedRegistration.getTime().toString());
        totalTreesLabel.setText(Integer.toString(selectedRegistration.getTrees().length));
        if(selectedRegistration.getStatus() == RegistrationStatus.Finished) {
            var filter = new DecisionFilter();
            filter.setRegistrationId(selectedRegistration.getId());
            var decision = webClientService.sendRequest(HttpMethod.GET, "/decision/get", filter, DecisionFilter.class, DecisionDto.class);
            decisionLabel.setText(decision.getDescription());
        }
    }
}
