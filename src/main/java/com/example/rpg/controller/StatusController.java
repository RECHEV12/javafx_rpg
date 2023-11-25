package com.example.rpg.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import static com.example.rpg.GameUtillMethod.user;
import static com.example.rpg.UsefullMethod.*;

public class StatusController {
    @FXML
    private Label user_name;

    @FXML
    private Label user_class;

    @FXML
    private Label user_lv;

    @FXML
    private Label user_hp;

    @FXML
    private Label user_mp;

    @FXML
    private Label user_exp;

    @FXML
    private Label user_STR;

    @FXML
    private Label user_DEX;

    @FXML
    private Label user_INT;

    @FXML
    private Label user_LUK;

    @FXML
    private Label user_extraStat;

    @FXML
    private Label user_money;
    @FXML
    private Label user_weapon;
    @FXML
    private Label user_equip;
    @FXML
    private ProgressBar hpBar;
    @FXML
    private ProgressBar mpBar;
    @FXML
    private ProgressBar expBar;



    @FXML
    public void inputStatData() {

        user_name.setText(user.getPlayerName());
        user_class.setText(user.getPlayerClass());
        user_lv.setText(user.getLv() + "");


        double hp = (double) user.getStatNowHP() / user.getStatMaxHP();
        double mp = (double) user.getStatNowMP() / user.getStatMaxMP();
        double exp = (double) user.getExp() / user.getNextExp();


        user_hp.setText(user.getStatNowHP() + "/" + user.getStatMaxHP());
        hpBar.setProgress(hp);
        user_mp.setText(user.getStatNowMP() + "/" + user.getStatMaxMP());
        mpBar.setProgress(mp);
        user_exp.setText(user.getExp() + "/" + user.getNextExp());
        expBar.setProgress(exp);

        user_STR.setText(user.getStatSTR() + "");
        user_DEX.setText(user.getStatDEX() + "");
        user_INT.setText(user.getStatINT() + "");
        user_LUK.setText(user.getStatINT() + "");

        user_extraStat.setText(user.getExtraStat() + "");
        user_money.setText(user.getMoney() + "");
        user_weapon.setText(user.getWeapon().getItemName());
        user_equip.setText(user.getEquip().getItemName());

    }

    @FXML
    public void backStage() {
        goBack(user_class);
    }

    @FXML
    public void goHome() {
        changeHome(user_class);
    }
}
