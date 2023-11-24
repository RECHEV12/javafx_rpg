package com.example.rpg.controller;

import com.example.rpg.GameUtillMethod;
import com.example.rpg.monster.Monster;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.example.rpg.GameUtillMethod.*;
import static com.example.rpg.UsefullMethod.changeHome;
import static com.example.rpg.UsefullMethod.goBack;

public class BattleController {

    @FXML
    public Label monsterName;


    @FXML
    public void showMonster() {
        System.out.println(nowMob);
        setMob();
    }

    public void setMob() {
        String mobName = "";
        if (nowMob.getMonsterName() == null) {

            nowMob = nowMonsterList.get(makeRandom(0, nowMonsterList.size() - 1));
            setMonster(nowMob, user);

            double rare = random5perRare();

            if (rare == 1.0) {
                isRare = 0;

            } else if (rare == 1.5) {
                isRare = 1;
            }
        }

        if (isRare == 0) {
            mobName = nowMob.getMonsterName();
        } else {
            mobName = "!!!" + nowMob.getMonsterName();
        }
        monsterName.setText(mobName);

    }



}
