// CMPT 381 - Assignement 1 - Derek Steeg dms224 - Prof Carl Gutwin

package com.example.cmpt381_a1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ColorSlider extends StackPane {

    // The entire slider box will sit inside an HBox
    private HBox root;

    // This class needs access to the main Circle swatch so that it can redraw the color when the sliders are sliding
    private Circle mainCircle;

    // values needed for each slider required
    private Label colorText;
    public Label colorValue;
    private Color currentColour;

    public Slider colorSlider;

    // INITIALIZER
    public ColorSlider(String string, Circle mainCircle) {

        // initialize the root
        root = new HBox();
        root.setSpacing(10);

        // initialize the color text, slider, and value
        colorText = new Label(string);
        colorSlider = new Slider(0, 255, 50);
        colorValue = new Label(String.valueOf(50));

        // add the widgets to the root
        root.getChildren().addAll(colorText, colorSlider, colorValue);

        // now, when we call on this constructor, we should have a CustomSlider Object with base values!
    }

    public int getValue() {
        return (int)colorSlider.getValue();
    }

    public void setValue(int value) {
        colorSlider.setValue(value);
    }

    // method to get the root of a custom slider
    public HBox getRoot() {
        return root;
    }
}
