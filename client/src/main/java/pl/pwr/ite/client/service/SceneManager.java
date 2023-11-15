package pl.pwr.ite.client.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;
import pl.pwr.ite.client.ClientApplication;
import pl.pwr.ite.client.model.dto.UserDto;
import pl.pwr.ite.client.model.enums.Scenes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private static SceneManager INSTANCE;
    private final Map<Scenes, Pane> screens = new HashMap<>();

    @Getter @Setter private UserDto userContext;
    @Getter @Setter private Scene mainScene;

    public void addScreen(Scenes scene, String fileName) {
        screens.put(scene, loadFromFxml(fileName));
    }

    public void switchScreen(Scenes scene) {
        mainScene.setRoot(screens.get(scene));
    }

    private Pane loadFromFxml(String fileName) {
        try {
            return new FXMLLoader(ClientApplication.class.getResource(fileName)).load();
        } catch (IOException ex) {
            throw new IllegalArgumentException(String.format("Couldn't load scene from file %s", fileName), ex);
        }
    }

    public static SceneManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SceneManager();
        }
        return INSTANCE;
    }
}
