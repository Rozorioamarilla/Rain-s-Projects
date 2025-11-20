/**
 * JavaFX Template Application Module
 * <p>
 * Demonstrates modern Java modular architecture with JavaFX.
 * Uses the Java Platform Module System (JPMS) for proper encapsulation
 * and dependency management.
 * </p>
 */
module org.lsr7.sta {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires java.logging;

    opens org.lsr7.sta.application to javafx.graphics, javafx.fxml;
    exports org.lsr7.sta.application;

    // Resource files (images) live under `resources/img` and don't need module opens.
}