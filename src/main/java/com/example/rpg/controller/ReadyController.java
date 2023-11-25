package com.example.rpg.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.example.rpg.GameUtillMethod.nowFieldName;
import static com.example.rpg.UsefullMethod.*;

public class ReadyController {
    @FXML
    private Label fieldName;

    @FXML
    public void setField() {
        if (nowFieldName.isEmpty()){

        fieldName.setText("asdf");
        }else {

        fieldName.setText(nowFieldName);
        }
    }

    @FXML
    public void backStage() {
        goField(fieldName);
    }

    @FXML
    public void goHome() {
        changeHome(fieldName);
    }

    @FXML
    public void showBattle() {
        goBattle(fieldName);
    }

    @FXML
    public void showStat() {
        goStatus(fieldName);
    }

    @FXML
    public void showItemBox() {
        goItemBox(fieldName);

    }
}

