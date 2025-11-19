package org.lsr7.sta.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.lsr7.sta.util.AppConstants;
import org.lsr7.sta.util.ResourceLoader;
import org.lsr7.sta.util.DialogHelper;
import java.util.logging.Logger;

public class MainController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());

    @FXML
    private BorderPane mainPane;

    @FXML
    public void handlePopupWindow(ActionEvent event) {
        LOGGER.info("Opening popup window");
        loadWindow(AppConstants.POPUP_WINDOW, "Popup Window");
    }

    @FXML
    public void handleLSW(ActionEvent event) {
        LOGGER.info("Loading LSW image");
        loadImageToCenter(AppConstants.IMAGE_LSW);
    }

    @FXML
    public void initialize() {
        LOGGER.fine("Initializing MainController");
        setMainPane(mainPane);
        loadImageToCenter(AppConstants.IMAGE_STA);
    }

    private void loadImageToCenter(String imagePath) {
        try {
            ImageView imageView = new ImageView(ResourceLoader.getImage(imagePath));
            imageView.setPreserveRatio(true);
            imageView.fitWidthProperty().bind(mainPane.widthProperty().multiply(0.8));
            imageView.fitHeightProperty().bind(mainPane.heightProperty().multiply(0.8));
            mainPane.setCenter(imageView);
            LOGGER.info("Image loaded successfully: " + imagePath);
        } catch (Exception e) {
            LOGGER.severe("Failed to load image: " + imagePath + " - " + e.getMessage());
            DialogHelper.showError("Image Load Error",
                    "Failed to load image: " + imagePath + "\n" + e.getMessage());
        }
    }
}
