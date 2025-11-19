package org.lsr7.sta.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import java.net.URL;
import java.util.logging.Logger;

public final class ResourceLoader {
    private static final Logger LOGGER = Logger.getLogger(ResourceLoader.class.getName());
    
    private ResourceLoader() {}
    
    public static FXMLLoader getFXMLLoader(String path) {
        URL resource = ResourceLoader.class.getResource(path);
        if (resource == null) {
            LOGGER.severe("FXML not found: " + path);
            throw new IllegalArgumentException("FXML resource not found: " + path);
        }
        return new FXMLLoader(resource);
    }
    
    public static Image getImage(String path) {
        try {
            var stream = ResourceLoader.class.getResourceAsStream(path);
            if (stream == null) {
                LOGGER.severe("Image not found: " + path);
                throw new IllegalArgumentException("Image resource not found: " + path);
            }
            return new Image(stream);
        } catch (Exception e) {
            LOGGER.severe("Failed to load image: " + path + " - " + e.getMessage());
            throw new RuntimeException("Failed to load image: " + path, e);
        }
    }
    
    // Get stylesheet as external form for Scene
    public static String getStylesheet(String path) {
        URL resource = ResourceLoader.class.getResource(path);
        if (resource == null) {
            LOGGER.severe("Stylesheet not found: " + path);
            throw new IllegalArgumentException("Stylesheet resource not found: " + path);
        }
        return resource.toExternalForm();
    }
}
