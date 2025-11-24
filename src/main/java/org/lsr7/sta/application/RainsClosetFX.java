package org.lsr7.sta.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RainsClosetFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/rains_closet.fxml")
        );

        Scene scene = new Scene(loader.load(), 900, 700);
        stage.setScene(scene);
        stage.setTitle("Rain's Closet");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
