package org.lsr7.sta.application;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class RainsClosetFX extends Application {
    // ImageViews for each layer
    private ImageView bodyView;
    private ImageView topClothesView;
    private ImageView bottomClothesView;
    private ImageView shoesView;
    private ImageView fullClothesView;
    private ImageView bangsView;
    private ImageView backHairView;
    private ImageView glassesView;
    private ImageView backgroundView;

    // Map for clothing images
    private Map<String, Image> clothesMap = new HashMap<>();

    @Override
    public void start(Stage stage) {
        // Load images
        clothesMap.put("bearTop", new Image("file:img/bearTop.png"));
        clothesMap.put("pinkTop", new Image("file:img/pinkTop.png"));
        clothesMap.put("angelTop", new Image("file:img/angelTop.png"));
        clothesMap.put("blackBottom", new Image("file:img/blackBottom.png"));
        clothesMap.put("bowBottom", new Image("file:img/bowBottom.png"));
        clothesMap.put("tights", new Image("file:img/tights.png"));
        clothesMap.put("melShoes", new Image("file:img/melShoes.png"));
        clothesMap.put("boots", new Image("file:img/boots.png"));
        clothesMap.put("dress", new Image("file:img/dress.png"));
        clothesMap.put("glasses", new Image("file:img/glasses.png"));
        clothesMap.put("bangs", new Image("file:img/bangs.png"));
        clothesMap.put("backHair", new Image("file:img/backHair.png"));
        clothesMap.put("body", new Image("file:img/body.png"));
        clothesMap.put("background", new Image("file:img/background.png"));

        // Create ImageViews
        backgroundView = new ImageView(clothesMap.get("background"));
        bodyView = new ImageView(clothesMap.get("body"));
        backHairView = new ImageView(clothesMap.get("backHair"));
        bangsView = new ImageView(clothesMap.get("bangs"));
        glassesView = new ImageView(clothesMap.get("glasses"));
        topClothesView = new ImageView(clothesMap.get("bearTop")); // default top
        bottomClothesView = new ImageView(clothesMap.get("blackBottom")); // default bottom
        shoesView = new ImageView(clothesMap.get("melShoes")); // default shoes
        fullClothesView = new ImageView(clothesMap.get("dress")); // default full clothes

        // Set preferred sizes (example: 800x800)
        int imgWidth = 800, imgHeight = 800;
        for (ImageView iv : new ImageView[]{bodyView, backHairView, bangsView, glassesView, topClothesView, bottomClothesView, shoesView, fullClothesView}) {
            iv.setFitWidth(imgWidth);
            iv.setFitHeight(imgHeight);
            iv.setPreserveRatio(true);
        }
        backgroundView.setFitWidth(imgWidth);
        backgroundView.setFitHeight(imgHeight);
        backgroundView.setPreserveRatio(true);

        // Layer images in StackPane
        StackPane root = new StackPane();
        root.getChildren().addAll(
            backgroundView,
            bodyView,
            backHairView,
            bangsView,
            glassesView,
            topClothesView,
            bottomClothesView,
            shoesView,
            fullClothesView
        );

        Scene scene = new Scene(root, imgWidth, imgHeight);
        stage.setTitle("Rain's Closet (JavaFX)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
