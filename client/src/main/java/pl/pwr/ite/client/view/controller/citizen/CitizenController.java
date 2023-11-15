package pl.pwr.ite.client.view.controller.citizen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import lombok.Getter;
import pl.pwr.ite.client.ClientApplication;

import java.io.IOException;

@Getter
public class CitizenController {

    @FXML
    protected BorderPane mainBorderPane;

    @FXML
    protected void createButtonClick(ActionEvent event) throws IOException {
        mainBorderPane.setCenter(new FXMLLoader(ClientApplication.class.getResource("citizen-create-registration-view.fxml")).load());
    }

    @FXML
    protected void listButtonClick(ActionEvent event) throws IOException {
        mainBorderPane.setCenter(new FXMLLoader(ClientApplication.class.getResource("citizen-registration-list-view.fxml")).load());
    }
}
