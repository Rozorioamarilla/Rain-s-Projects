package org.lsr7.sta.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.logging.Logger;

public class PopupWindowController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(PopupWindowController.class.getName());

    @FXML
    public void handleCloseWindow(ActionEvent event) {
        LOGGER.info("Closing popup window");
        // Close the popup window
        ((javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    public void initialize() {
        LOGGER.fine("Initializing PopupWindowController");
    }
}
