// CMPT 381 - Assignement 1 - Derek Steeg dms224 - Prof Carl Gutwin

package com.example.cmpt381_a1;

import javafx.scene.control.ListCell;
import javafx.scene.layout.StackPane;

public class PaletteCell extends ListCell<ColorPalette> {

    public void updateItem(ColorPalette item, boolean empty) {
        super.updateItem(item, empty);
        PaletteView PV = new PaletteView(item);
        setGraphic(PV);
    }
}
