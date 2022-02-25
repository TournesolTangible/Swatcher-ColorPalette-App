// CMPT 381 - Assignement 1 - Derek Steeg dms224 - Prof Carl Gutwin

package com.example.cmpt381_a1;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaletteView extends StackPane {
    // An HBox to hold the object
    private HBox root;

    // PaletteView objects will contain three Circle objects and a reference to the ColorPalette object
    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    private ColorPalette colorPalette;

    // Initializer
    public PaletteView (ColorPalette mainCP) {

        root = new HBox();

        if(mainCP != null)
        {
            colorPalette = mainCP;

            circle1 = new Circle(20);
            circle2 = new Circle(20);
            circle3 = new Circle(20);
            circle1.setFill(colorPalette.getColor1());
            circle2.setFill(colorPalette.getColor2());
            circle3.setFill(colorPalette.getColor3());
        } else {
            circle1 = new Circle(20);
            circle2 = new Circle(20);
            circle3 = new Circle(20);
            colorPalette = new ColorPalette();
            circle1.setFill(colorPalette.getColor1());
            circle2.setFill(colorPalette.getColor2());
            circle3.setFill(colorPalette.getColor3());
        }

        // add everything to the root
        root.getChildren().addAll(circle1, circle2, circle3);
        this.getChildren().add(root);
    }

    public HBox getRoot() {
        return root;
    }

}
