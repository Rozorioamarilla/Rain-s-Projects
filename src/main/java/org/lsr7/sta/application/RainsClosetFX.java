package org.lsr7.sta.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RainsClosetFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(
            FXMLLoader.load(getClass().getResource("/fxml/rains_closet.fxml")),
            900, 700
        );
        stage.setScene(scene);
        stage.setTitle("Rain's Closet");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
