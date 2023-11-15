package pl.pwr.ite.client.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import pl.pwr.ite.client.model.dto.UserDto;
import pl.pwr.ite.client.model.enums.Scenes;
import pl.pwr.ite.client.service.SceneManager;
import pl.pwr.ite.client.service.WebClientService;
import pl.pwr.ite.client.service.WebClientService;

import java.io.*;

public class LoginController {
    private final SceneManager sceneManager = SceneManager.getInstance();
    private final WebClientService webClientService = WebClientService.getInstance();
    @FXML protected VBox treesContainer;
    @FXML protected Button loginButton;
    @FXML protected TextField nameTextField;

    @FXML
    protected void loginButtonClick(ActionEvent event) throws IOException {
        var userDto = new UserDto();
        userDto.setName(nameTextField.getText());
        var response = webClientService.sendRequest("/user/get-by-name", userDto, UserDto.class, UserDto.class);
        if(response != null) {
            sceneManager.setUserContext(response);
            switch (response.getType()) {
                case Citizen -> sceneManager.switchScreen(Scenes.Citizen);
                case Inspector -> sceneManager.switchScreen(Scenes.Inspector);
                case Manager -> sceneManager.switchScreen(Scenes.Manager);
            }
        }
    }
}