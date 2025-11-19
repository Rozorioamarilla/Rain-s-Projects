package org.lsr7.sta.controller;

import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import org.lsr7.sta.util.ResourceLoader;
import org.lsr7.sta.util.DialogHelper;
import java.util.logging.Logger;

public class BaseController {
    private static final Logger LOGGER = Logger.getLogger(BaseController.class.getName());
    private BorderPane mainPane;

    public void setMainPane(BorderPane mainPane) {
        this.mainPane = mainPane;
    }

    protected void loadWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = ResourceLoader.getFXMLLoader(fxmlPath);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
            LOGGER.info("Window loaded: " + title);
        } catch (Exception e) {
            LOGGER.severe("Failed to load window: " + fxmlPath + " - " + e.getMessage());
            DialogHelper.showError("Window Load Error",
                    "Failed to load window: " + fxmlPath + "\n" + e.getMessage());
        }
    }

    protected void changeScene(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = ResourceLoader.getFXMLLoader(fxmlPath);
            Parent view = loader.load();
            BaseController controller = loader.getController();
            controller.setMainPane(mainPane);
            mainPane.setCenter(view);
            LOGGER.info("Scene changed to: " + fxmlPath);
        } catch (Exception e) {
            LOGGER.severe("Failed to change scene: " + fxmlPath + " - " + e.getMessage());
            DialogHelper.showError("Scene Change Error",
                    "Failed to change scene: " + fxmlPath + "\n" + e.getMessage());
        }
    }
}
