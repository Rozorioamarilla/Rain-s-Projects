package org.lsr7.sta.util;

/**
 * Centralized, immutable collection of application-wide constants and resource
 * paths.
 * <p>
 * Provides titles, default window dimensions, and classpath locations for FXML,
 * CSS, and image assets used throughout the application.
 * </p>
 */
public final class AppConstants {
    private AppConstants() {
    } // Prevent instantiation

    // Application
    public static final String APP_TITLE = "JavaFX Template";
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;

    // FXML Paths
    public static final String MAIN_VIEW = "/fxml/MainView.fxml";
    public static final String POPUP_WINDOW = "/fxml/PopupWindow.fxml";

    // CSS Paths
    public static final String MAIN_STYLESHEET = "/css/mainView.css";

    // Image Paths
    public static final String IMAGE_STA = "/images/sta.png";
    public static final String IMAGE_LSW = "/images/lsw.jpg";
}
