package org.lsr7.sta.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.lsr7.sta.util.AppConstants;
import org.lsr7.sta.util.ResourceLoader;

import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App extends Application {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    static {
        // Load logging configuration before any loggers are created
        try (InputStream config = App.class.getResourceAsStream("/logging.properties")) {
            if (config != null) {
                LogManager.getLogManager().readConfiguration(config);
            } else {
                System.err.println("Warning: logging.properties not found, using defaults");
            }
        } catch (Exception e) {
            System.err.println("Failed to load logging configuration: " + e.getMessage());
        }
    }

    @Override
    public void start(Stage stage) {
        try {
            LOGGER.info("Starting application...");
            
            FXMLLoader loader = ResourceLoader.getFXMLLoader(AppConstants.MAIN_VIEW);
            Parent root = loader.load();

            Scene scene = new Scene(root, AppConstants.DEFAULT_WIDTH, AppConstants.DEFAULT_HEIGHT);

            // Apply stylesheet programmatically using constant
            String stylesheet = ResourceLoader.getStylesheet(AppConstants.MAIN_STYLESHEET);
            scene.getStylesheets().add(stylesheet);

            stage.setTitle(AppConstants.APP_TITLE);
            stage.setScene(scene);
            stage.show();

            LOGGER.info("Application started successfully");
        } catch (Exception e) {
            LOGGER.severe("Failed to start application: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Application startup failed", e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
