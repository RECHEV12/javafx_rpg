package com.example.rpg.controller;


import javafx.fxml.FXML;

import javafx.scene.control.Label;

import static com.example.rpg.GameUtillMethod.user;
import static com.example.rpg.UsefullMethod.*;

public class MainController {
    @FXML
    private Label userClass;
    @FXML
    private Label userLevel;
    @FXML
    private Label userWeapon;
    @FXML
    private Label userEquip;
    @FXML
    private Label userName;



    @FXML
    public void startGame() {


        userClass.setText("직업 : " + user.getPlayerClass());
        userLevel.setText("Lv. " + user.getLv());
        userName.setText("이름 : " + user.getPlayerName());

        if (user.getWeapon().getItemName() == null) {
            userWeapon.setText("무기 : 없음");
        } else {
            userWeapon.setText("무기 : " + user.getWeapon().getItemName() );
        }

        if (user.getEquip().getItemName() == null) {
            userEquip.setText("방어구 : 없음");
        } else {

            userEquip.setText("방어구 : " + user.getEquip().getItemName());
        }

    }

    @FXML
    public void showField() {
        goField(userClass);
    }

    @FXML
    public void showStat() {
        goStatus(userClass);
    }

    @FXML
    public void showSkill() {
        goSkillList(userClass);
    }


    @FXML
    public void showItemBox() {
        goItemBox(userClass);

    }

    @FXML
    public void showShop() {
      goShop(userClass);
    }

}
