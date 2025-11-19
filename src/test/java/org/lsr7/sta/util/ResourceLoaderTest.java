package org.lsr7.sta.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class ResourceLoaderTest {

    @Test
    @DisplayName("Should throw exception for missing FXML")
    void testLoadMissingFXML() {
        assertThrows(IllegalArgumentException.class, () -> {
            ResourceLoader.getFXMLLoader("/fxml/nonexistent.fxml");
        });
    }

    @Test
    @DisplayName("Should throw exception for missing image")
    void testLoadMissingImage() {
        assertThrows(RuntimeException.class, () -> {
            ResourceLoader.getImage("/images/nonexistent.png");
        });
    }

    @Test
    @DisplayName("Should throw exception for missing stylesheet")
    void testLoadMissingStylesheet() {
        assertThrows(IllegalArgumentException.class, () -> {
            ResourceLoader.getStylesheet("/css/nonexistent.css");
        });
    }
    
    @Test
    @DisplayName("Should get valid stylesheet path")
    void testGetValidStylesheet() {
        assertDoesNotThrow(() -> {
            String stylesheet = ResourceLoader.getStylesheet(AppConstants.MAIN_STYLESHEET);
            assertNotNull(stylesheet);
            assertTrue(stylesheet.contains("mainView.css"));
        });
    }
}
