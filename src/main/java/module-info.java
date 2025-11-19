/**
 * JavaFX Template Application Module
 * <p>
 * Demonstrates modern Java modular architecture with JavaFX.
 * Uses the Java Platform Module System (JPMS) for proper encapsulation
 * and dependency management.
 * </p>
 */
module org.lsr7.sta.javafx {
    // JavaFX requirements
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    
    // Java standard library modules
    requires java.logging;
    
    // Open packages for JavaFX FXML reflection access
    opens org.lsr7.sta.controller to javafx.fxml;
    opens org.lsr7.sta.application to javafx.graphics;
    
    // Export public API packages
    exports org.lsr7.sta.application;
    exports org.lsr7.sta.controller;
    exports org.lsr7.sta.util;
}