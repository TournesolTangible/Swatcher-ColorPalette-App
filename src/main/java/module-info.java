module com.example.cmpt381_a1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cmpt381_a1 to javafx.fxml;
    exports com.example.cmpt381_a1;
}