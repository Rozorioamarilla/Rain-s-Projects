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
        // Load images from the classpath `resources/img` folder (robustly)
        clothesMap.put("bearTop", loadImage("/img/bearTop.png"));
        clothesMap.put("pinkTop", loadImage("/img/pinkTop.png"));
        clothesMap.put("angelTop", loadImage("/img/angelTop.png"));
        clothesMap.put("blackBottom", loadImage("/img/blackBottom.png"));
        clothesMap.put("bowBottom", loadImage("/img/bowBottom.png"));
        clothesMap.put("tights", loadImage("/img/tights.png"));
        clothesMap.put("melShoes", loadImage("/img/melShoes.png"));
        clothesMap.put("boots", loadImage("/img/boots.png"));
        clothesMap.put("dress", loadImage("/img/dress.png"));
        clothesMap.put("glasses", loadImage("/img/glasses.png"));
        clothesMap.put("bangs", loadImage("/img/bangs.png"));
        clothesMap.put("backHair", loadImage("/img/backHair.png"));
        clothesMap.put("body", loadImage("/img/body.png"));
        clothesMap.put("background", loadImage("/img/background.png"));

        // Create ImageViews (only for successfully loaded images)
        backgroundView = createView(clothesMap.get("background"));
        bodyView = createView(clothesMap.get("body"));
        backHairView = createView(clothesMap.get("backHair"));
        bangsView = createView(clothesMap.get("bangs"));
        glassesView = createView(clothesMap.get("glasses"));
        topClothesView = createView(clothesMap.get("bearTop")); // default top
        bottomClothesView = createView(clothesMap.get("blackBottom")); // default bottom
        shoesView = createView(clothesMap.get("melShoes")); // default shoes
        fullClothesView = createView(clothesMap.get("dress")); // default full clothes

        // Layer images in StackPane (preserve order for proper layering)
        StackPane root = new StackPane();
        if (backgroundView != null) root.getChildren().add(backgroundView);
      
        if (backHairView != null) root.getChildren().add(backHairView);


        if (bodyView != null) root.getChildren().add(bodyView);

        if (topClothesView != null) root.getChildren().add(topClothesView);
        if (bottomClothesView != null) root.getChildren().add(bottomClothesView);
        if (shoesView != null) root.getChildren().add(shoesView);
        if (fullClothesView != null) root.getChildren().add(fullClothesView);

        if (glassesView != null) root.getChildren().add(glassesView);
        if (bangsView != null) root.getChildren().add(bangsView);

        // Start scene with a reasonable default size; views will bind to scene size
        Scene scene = new Scene(root, 800, 800);

        // Make ImageViews responsive to window size
        for (ImageView iv : new ImageView[]{backgroundView, bodyView, backHairView, bangsView, glassesView, topClothesView, bottomClothesView, shoesView, fullClothesView}) {
            if (iv == null) continue;
            iv.setPreserveRatio(true);
            iv.fitWidthProperty().bind(scene.widthProperty());
            iv.fitHeightProperty().bind(scene.heightProperty());
        }
        stage.setTitle("Rain's Closet (JavaFX)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Helper: load image from classpath, return null if not found
    private Image loadImage(String resourcePath) {
        try {
            var res = getClass().getResource(resourcePath);
            if (res == null) {
                System.err.println("Resource not found: " + resourcePath);
                return null;
            }
            return new Image(res.toExternalForm());
        } catch (Exception e) {
            System.err.println("Failed to load image: " + resourcePath + " - " + e.getMessage());
            return null;
        }
    }

    // Helper: create an ImageView or return null when image is null
    private ImageView createView(Image img) {
        if (img == null) return null;
        ImageView iv = new ImageView(img);
        iv.setPreserveRatio(true);
        return iv;
    }
}
