// CMPT 381 - Assignement 1 - Derek Steeg dms224 - Prof Carl Gutwin

package com.example.cmpt381_a1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class HelloApplication<customSlider> extends Application {

    // The main window root
    private HBox root;

    // The halves of the screen
    private VBox leftScreen;
    private VBox rightScreen;

    // Boxes in leftScreen
    private Circle colorCircle;            // The main color selected by the sliders
    private ColorSlider sliderRed;         // The slider class for each color value (r/g/b)
    private ColorSlider sliderGreen;
    private ColorSlider sliderBlue;
    private Button addToPaletteButton;     // The button which will add a color to the palette
    private ColorPalette colorPalette;     // The palette class which holds the 3 colors selected
    private Button addToListButton;        // The button which will add a palette object to the listView
    private Color currentColor;            // The current color decided by the sliders

    // Boxes in rightScreen
    private Label listLabel;                     // The label of the list which holds palettes
    private ListView<ColorPalette> myListView;   // The palettes held in the list
    private PaletteView paletteView;             // The Object which is used to update the list view
    ObservableList<ColorPalette> paletteList;


    @Override
    public void start(Stage stage) {

        // create a new root (window) using HBox()
        // this will be the base of the window which splits it into Left/Right halves
        // the left half is for tinkering with the color and palette
        // the right half is for storing the palettes in a list view
        root = new HBox(16);
        root.setPrefSize(600, 400);
        root.setSpacing(75);
        root.setPadding(new Insets(20, 20, 20, 20));

        // set the left and right sides of the screen
        leftScreen = new VBox();
        leftScreen.setPadding(new Insets(10, 10, 10, 10));
        leftScreen.setSpacing(10);
        rightScreen = new VBox();

        // initialize a Circle class to start
        colorCircle = new Circle();
        colorCircle.setFill(Color.WHITE);
        colorCircle.setCenterX(50);
        colorCircle.setRadius(100);

        // initialize a Label class and ListView<ColorPalette> to identify the list view
        listLabel = new Label("Palette List:");
        listLabel.setLabelFor(myListView);

        // Handle adding palettes to the list
        paletteList = FXCollections.observableArrayList();
        myListView = new ListView<>(paletteList);
        myListView.setItems(paletteList);
        myListView.setCellFactory(listItem -> new PaletteCell());
        //paletteView = new PaletteView(colorPalette);

        // initialize ColorSlider object for each value of RGB
        sliderRed = new ColorSlider("Red   ", colorCircle);
        sliderGreen = new ColorSlider("Green", colorCircle);
        sliderBlue =  new ColorSlider("Blue   ", colorCircle);


        // Listeners to change the color of the main Circle swatch
        sliderRed.colorSlider.valueProperty().addListener((observable, oldValue, newValue) -> { setColor(); sliderRed.colorValue.setText(String.valueOf((int)sliderRed.colorSlider.getValue())); });
        sliderGreen.colorSlider.valueProperty().addListener((observable, oldValue, newValue) -> { setColor(); sliderGreen.colorValue.setText(String.valueOf((int)sliderGreen.colorSlider.getValue())); });
        sliderBlue.colorSlider.valueProperty().addListener((observable, oldValue, newValue) -> { setColor(); sliderBlue.colorValue.setText(String.valueOf((int)sliderBlue.colorSlider.getValue())); });

        // create a button for adding colors to palette
        addToPaletteButton = new Button("Add to palette");
        addToPaletteButton.setOnAction((actionEvent -> colorPalette.addColor( (Color) colorCircle.getFill())));

        // create a ColorPalette for holding the colors
        colorPalette = new ColorPalette();

        // create an "addToList" Button for adding palettes to the list on the rightScreen
        addToListButton = new Button("Add to list ->");
        addToListButton.setOnAction(this::HandleSaveClick);


        // add widgets to leftScreen
        leftScreen.getChildren().addAll(colorCircle, sliderRed.getRoot(), sliderGreen.getRoot(), sliderBlue.getRoot(),
                addToPaletteButton, colorPalette.getRoot(), addToListButton);

        // add widgets to rightScreen
        rightScreen.getChildren().addAll(listLabel, myListView);

        // finally, add them to the main window root
        root.getChildren().addAll(leftScreen, rightScreen);

        // initalize scene and present
        Scene scene = new Scene(root);
        stage.setTitle("SWATCHER   -   CMPT 381 - Assignment 1 - Derek Steeg dms224");
        stage.setScene(scene);
        stage.show();
    }

    // to handle the "addToList" button click
    public void HandleSaveClick(ActionEvent e)
    {
        ColorPalette copy = colorPalette.Copy();
        paletteList.add(copy);
        System.out.println("CLICK");
    }

    private void setColor() {
        currentColor = Color.rgb(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue());
        colorCircle.setFill(currentColor);
    }

    public static void main(String[] args) {
        launch();
    }
}