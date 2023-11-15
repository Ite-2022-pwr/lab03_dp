package pl.pwr.ite.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.pwr.ite.client.model.enums.Scenes;
import pl.pwr.ite.client.service.SceneManager;

import java.io.IOException;

public class ClientApplication extends Application {

    private final SceneManager sceneManager = SceneManager.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1500, 750);
        setupSceneManager(scene);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void setupSceneManager(Scene scene) {
        sceneManager.setMainScene(scene);
        sceneManager.addScreen(Scenes.Login, "login-view.fxml");
        sceneManager.addScreen(Scenes.Citizen, "citizen-view.fxml");
        sceneManager.addScreen(Scenes.Inspector, "inspector-view.fxml");
        sceneManager.addScreen(Scenes.Manager, "manager-view.fxml");
    }
}