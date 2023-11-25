package com.example.rpg.controller;


import com.example.rpg.monster.Monster;
import com.example.rpg.monster.MonsterDB;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

import static com.example.rpg.GameUtillMethod.*;
import static com.example.rpg.UsefullMethod.*;

public class FieldController {
    ArrayList<Monster> monsterList = MonsterDB.getInstance().getMonsterList();
    @FXML
    private Label label;

    @FXML
    protected void goFirstField() {
        nowFieldName = "드넓은 평원 레벨 : 제한 없음";
        setNowMonsterList(1);

    }

    @FXML
    protected void goSecondField() {
        if (user.getLv() < 10) {
            showAlertErr("레벨이 부족합니다");
            return;
        }
        nowFieldName = "무너진 성터 레벨 : 10이상";
        setNowMonsterList(2);

    }

    @FXML
    protected void goThirdField() {
        if (user.getLv() < 20) {
            showAlertErr("레벨이 부족합니다");
            return;
        }
        nowFieldName = "옛 전쟁터 레벨 : 20이상";
        setNowMonsterList(3);

    }

    @FXML
    protected void goFourthField() {
        if (user.getLv() < 30) {
            showAlertErr("레벨이 부족합니다");
            return;
        }
        nowFieldName = "마왕성 레벨 : 30이상";
        setNowMonsterList(4);

    }

    @FXML
    protected void goFifthField() {
        if (user.getLv() < 10) {
            showAlertErr("레벨이 부족합니다");
            return;
        }
        nowFieldName = "보스전 : 대왕 슬라임 레벨 : 10이상";
        setNowMonsterList(5);

    }

    @FXML
    protected void goSixesField() {
        if (user.getLv() < 20) {
            showAlertErr("레벨이 부족합니다");
            return;
        }
        nowFieldName = "보스전 : 킹 고블린 레벨 : 20이상";
        setNowMonsterList(6);

    }

    @FXML
    protected void goSeventhField() {
        if (user.getLv() < 30) {
            showAlertErr("레벨이 부족합니다");
            return;
        }
        nowFieldName = "보스전 : 거대 골렘 레벨 : 30이상";
        setNowMonsterList(7);

    }

    @FXML
    protected void goEighthField() {
        if (user.getLv() != 40) {
            showAlertErr("레벨이 부족합니다");
            return;
        }
        nowFieldName = "보스전 : 드래곤 레벨 : 40";
        setNowMonsterList(8);

    }

    protected void setNowMonsterList(int num) {
        nowMonsterList.clear();
        for (Monster mob : monsterList) {
            if (mob.getMonsterGroup() == num) {

                nowMonsterList.add(mob);
            }
        }
        showReady();
    }

    @FXML
    public void lvUPUPUP() {
        user.setLv(user.getLv() + 1);
        userAddSkill(user);


    }

    @FXML
    public void showReady() {
        goReady(label);
    }

    @FXML
    public void backStage() {
        changeHome(label);
    }

    @FXML
    public void goHome() {
        changeHome(label);
    }
}
