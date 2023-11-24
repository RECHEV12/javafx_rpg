module com.example.rpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rpg to javafx.fxml;
    exports com.example.rpg;
    exports com.example.rpg.controller;
    opens com.example.rpg.controller to javafx.fxml;
}