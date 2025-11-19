package org.lsr7.sta.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.util.logging.Logger;

public final class DialogHelper {
    private static final Logger LOGGER = Logger.getLogger(DialogHelper.class.getName());
    
    private DialogHelper() {}
    
    public static void showError(String title, String message) {
        LOGGER.warning("Showing error dialog: " + title + " - " + message);
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void showInfo(String title, String message) {
        LOGGER.info("Showing info dialog: " + title);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static boolean showConfirmation(String title, String message) {
        LOGGER.info("Showing confirmation dialog: " + title);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        return alert.showAndWait().orElse(ButtonType.CANCEL) == ButtonType.OK;
    }
}
