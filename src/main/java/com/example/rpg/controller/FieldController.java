package com.example.rpg.controller;

import com.example.rpg.GameUtillMethod;
import com.example.rpg.monster.Monster;
import com.example.rpg.monster.MonsterDB;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

import static com.example.rpg.GameUtillMethod.nowFieldName;
import static com.example.rpg.GameUtillMethod.nowMonsterList;
import static com.example.rpg.UsefullMethod.*;

public class FieldController {
    ArrayList<Monster> monsterList = MonsterDB.getInstance().getMonsterList();
    @FXML
    private Label label;

    @FXML
    protected void goFirstField() {
        nowFieldName = "드넓은 평원";
        setNowMonsterList(1);

    }

    @FXML
    protected void goSecondField() {
        nowFieldName = "무너진 성터";
        setNowMonsterList(2);

    }

    @FXML
    protected void goThirdField() {
        nowFieldName = "옛 전쟁터";
        setNowMonsterList(3);

    }

    @FXML
    protected void goFourthField() {
        nowFieldName = "마왕성";
        setNowMonsterList(4);

    }

    @FXML
    protected void goFifthField() {
        nowFieldName = "보스전 : 대왕 슬라임";
        setNowMonsterList(5);

    }

    @FXML
    protected void goSixesField() {
        nowFieldName = "보스전 : 킹 고블린";
        setNowMonsterList(6);

    }

    @FXML
    protected void goSeventhField() {
        nowFieldName = "보스전 : 거대 골렘";
        setNowMonsterList(7);

    }

    @FXML
    protected void goEighthField() {
        nowFieldName = "보스전 : 드래곤";
        setNowMonsterList(8);

    }

    protected void setNowMonsterList(int num) {
        for (Monster mob : monsterList) {
            if (mob.getMonsterGroup() == num) {

                nowMonsterList.add(mob);
            }
        }
        showReady();
    }
 @FXML
 public void showReady(){
     goReady(label);
 }
    @FXML
    public void backStage() {
        goBack(label);
    }

    @FXML
    public void goHome() {
        changeHome(label);
    }
}
