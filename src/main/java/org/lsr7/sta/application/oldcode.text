package org.lsr7.sta.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;

public class RainsClosetController {

    @FXML private StackPane rootStack;

    private Map<String, Image> clothesMap = new HashMap<>();

    // Layers
    private ImageView backgroundView;
    private ImageView bodyView;
    private ImageView backHairView;
    private ImageView bangsView;
    private ImageView glassesView;
    private ImageView topClothesView;
    private ImageView bottomClothesView;
    private ImageView shoesView;
    private ImageView fullClothesView;

    @FXML
    public void initialize() {
        loadImages();
        buildLayers();
    }

    private Image load(String path) {
        var res = getClass().getResource(path);
        if (res == null) {
            System.err.println("Missing: " + path);
            return null;
        }
        return new Image(res.toExternalForm());
    }

    private void loadImages() {
        clothesMap.put("background", load("/img/background.png"));
        clothesMap.put("body", load("/img/body.png"));
        clothesMap.put("backHair", load("/img/backHair.png"));
        clothesMap.put("bangs", load("/img/bangs.png"));
        clothesMap.put("glasses", load("/img/glasses.png"));

        clothesMap.put("bearTop", load("/img/bearTop.png"));
        clothesMap.put("pinkTop", load("/img/pinkTop.png"));
        clothesMap.put("angelTop", load("/img/angelTop.png"));

        clothesMap.put("blackBottom", load("/img/blackBottom.png"));
        clothesMap.put("bowBottom", load("/img/bowBottom.png"));

        clothesMap.put("melShoes", load("/img/melShoes.png"));
        clothesMap.put("boots", load("/img/boots.png"));

        clothesMap.put("dress", load("/img/dress.png"));
    }

    private ImageView iv(Image img) {
        if (img == null) return null;
        ImageView v = new ImageView(img);
        v.setPreserveRatio(true);
        v.setFitWidth(600);  // prevents cut-off scaling
        return v;
    }

    private void buildLayers() {
        backgroundView = iv(clothesMap.get("background"));
        bodyView = iv(clothesMap.get("body"));
        backHairView = iv(clothesMap.get("backHair"));
        bangsView = iv(clothesMap.get("bangs"));
        glassesView = iv(clothesMap.get("glasses"));

        topClothesView = iv(clothesMap.get("bearTop"));
        bottomClothesView = iv(clothesMap.get("blackBottom"));
        shoesView = iv(clothesMap.get("melShoes"));
        fullClothesView = iv(clothesMap.get("dress"));

        fullClothesView.setVisible(false); // start with separate items

        rootStack.getChildren().addAll(
                backgroundView,
                backHairView,
                bodyView,
                topClothesView,
                bottomClothesView,
                shoesView,
                fullClothesView,
                glassesView,
                bangsView
        );

        // Bind size to stack so nothing gets cut off
        rootStack.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.widthProperty().addListener((o, oldV, newV) -> resizeLayers(newV.doubleValue()));
                newScene.heightProperty().addListener((o, oldV, newV) -> resizeLayers(newV.doubleValue()));
            }
        });
    }

    private void resizeLayers(double scale) {
        for (var node : rootStack.getChildren()) {
            if (node instanceof ImageView iv) {
                iv.setFitWidth(scale * 0.6);
            }
        }
    }

    // BUTTON ACTIONS

    @FXML
    private void showTops() {
        topClothesView.setVisible(true);
        bottomClothesView.setVisible(false);
        shoesView.setVisible(false);
        fullClothesView.setVisible(false);
    }

    @FXML
    private void showBottoms() {
        topClothesView.setVisible(false);
        bottomClothesView.setVisible(true);
        shoesView.setVisible(false);
        fullClothesView.setVisible(false);
    }

    @FXML
    private void showShoes() {
        topClothesView.setVisible(false);
        bottomClothesView.setVisible(false);
        shoesView.setVisible(true);
        fullClothesView.setVisible(false);
    }

    @FXML
    private void showFullOutfits() {
        fullClothesView.setVisible(true);
        topClothesView.setVisible(false);
        bottomClothesView.setVisible(false);
        shoesView.setVisible(false);
    }

    @FXML
    private void showHair() {
        backHairView.setVisible(true);
        bangsView.setVisible(true);
        glassesView.setVisible(false);
    }

    @FXML
    private void showAccessories() {
        glassesView.setVisible(true);
        bangsView.setVisible(false);
    }
}
