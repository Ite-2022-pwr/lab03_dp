package pl.pwr.ite.client.view.controller.citizen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import pl.pwr.ite.client.model.dto.RegistrationDto;
import pl.pwr.ite.client.model.dto.TreeDto;
import pl.pwr.ite.client.service.SceneManager;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.view.model.TreeTableDataModel;

public class CreateRegistrationController {

    private final WebClientService webClientService = WebClientService.getInstance();
    private final SceneManager sceneManager = SceneManager.getInstance();

    @FXML protected TableView<TreeTableDataModel> treesTableView;
    @FXML protected VBox treesContainer;
    @FXML protected TextField treeNameTextField;
    @FXML protected TextField treeDiameterTextField;

    @FXML
    protected void addTreeButtonClick(ActionEvent event) {
        var data = treesTableView.getItems();
        var tree = new TreeDto();
        tree.setName(treeNameTextField.getText());
        tree.setDiameter(Double.parseDouble(treeDiameterTextField.getText()));
        data.add(new TreeTableDataModel(tree));
        treeNameTextField.setText("");
        treeDiameterTextField.setText("");
    }

    public void sendRegistrationButtonClick(ActionEvent event) {
        var data = treesTableView.getItems().stream().map(TreeTableDataModel::getTree).toList();
        var registration = new RegistrationDto();
        registration.setTrees(data.toArray(new TreeDto[0]));
        registration.setUser(sceneManager.getUserContext());

        webClientService.sendRequest("/registration", registration, RegistrationDto.class, RegistrationDto.class);
        treesTableView.getItems().clear();
    }
}
