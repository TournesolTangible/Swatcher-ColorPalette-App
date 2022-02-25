// CMPT 381 - Assignement 1 - Derek Steeg dms224 - Prof Carl Gutwin

package com.example.cmpt381_a1;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.LinkedList;

public class ColorPalette extends StackPane {
    // the base of the palette will be an HBox
    private HBox root;

    // three Circle objects to represent the palette
    private Circle circle1;
    private Circle circle2;
    private Circle circle3;

    // This class will store three Color objects for the colors of the palette
    private Color color1;
    private Color color2;
    private Color color3;

    // A counter for indexing the items of the list
    private Integer counter;

    // A linked list to hold the Color objects
    private LinkedList<Color> colorList;

    // A linked list to hold the Circle objects
    private LinkedList<Circle> circleList;


    public ColorPalette() {
        // initialize the pieces of the custom palette
        root = new HBox();
        root.setSpacing(10);
        root.setPadding(new Insets(5, 5, 5, 5));
        circle1 = new Circle(20);
        circle1.setFill(Color.WHITE);
        circle2 = new Circle(20);
        circle2.setFill(Color.WHITE);
        circle3 = new Circle(20);
        circle3.setFill(Color.WHITE);

        circleList = new LinkedList<Circle>();
        circleList.add(circle1);
        circleList.add(circle2);
        circleList.add(circle3);

        // initialize the three color objects default to WHITE
        color1 = Color.WHITE;
        color2 = Color.WHITE;
        color3 = Color.WHITE;


        // create a list to hold the colors in the current palette
        colorList = new LinkedList<Color>();
        colorList.add(color1);
        colorList.add(color2);
        colorList.add(color3);

        // counter for indexing through the circles of the palette
        counter = 0;

        // add the circles to the root
        root.getChildren().addAll(circle1, circle2, circle3);
        //this.getChildren().add(root);
    }

    // adds the current color to the palette
    public void addColor(Color c) {
        // if counter == index 2
        //     - or -
        // if counter is at last element,
        // reset counter to first item
        // set element(counter) to currentColor
        if (counter == 2) {
            colorList.set(counter, c);
            circleList.get(counter).setFill(c);
            counter = 0;
        } else {
            colorList.set(counter, c);
            circleList.get(counter).setFill(c);
            counter++;
        }
    }

    public ColorPalette Copy() {
        // creates a copy of the current color palette and returns it
        ColorPalette copy = new ColorPalette();
        copy.colorList.set(0, colorList.get(0));
        copy.colorList.set(1, colorList.get(1));
        copy.colorList.set(2, colorList.get(2));
        return copy;
    }

    public Color getColor1() {
        return colorList.get(0);
    }
    public Color getColor2() {
        return colorList.get(1);
    }
    public Color getColor3() {
        return colorList.get(2);
    }

    public String toString() {
        return circle1.getFill().toString() + " " + circle2.getFill().toString() + " " + circle3.getFill().toString();
    }

    public HBox getRoot() {
        return root;
    }

}
