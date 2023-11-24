package com.example.rpg.controller;

import com.example.rpg.GameUtillMethod;
import com.example.rpg.HelloApplication;
import com.example.rpg.UsefullMethod;
import com.example.rpg.character.Class;
import com.example.rpg.item.Item;
import com.example.rpg.skill.Skill;
import com.example.rpg.skill.SkillDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.rpg.GameUtillMethod.selectedClass;
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
    public void goShop() {
        user.getItemsList().add(new Item("몽둥이", "무기", 3, 3, 3, 0, 0, 0, 0, 0, "고블린이 들고다니던 몽둥이. 고블린이 드랍한다.", false, "고블린", 1000));
        user.getItemsList().add(new Item("고블린 도끼", "무기", 10, 5, 10, 0, 3, 3, 0, 0, "홉 고블린의 도끼", false, "홉고블린", 3000));

        user.getItemsList().add(new Item("끈적한 옷", "방어구", 2, 1, 2, 0, 3, 3, 3, 3, "슬라임의 점성으로 만든 끈적한 옷, 슬라임이 드랍한다.", false, "슬라임", 1000));
        user.getItemsList().add(new Item("큰 끈적한 옷", "방어구", 7, 3, 7, 0, 10, 10, 5, 5, "대왕 슬라임의 점성으로 만든 끈적한 옷. 대왕슬라임이 드랍한다.", false, "대왕슬라임", 2000));

        user.getItemsList().add(new Item("사과", "포션", 0, 0, 0, 0, 10, 0, 5, 0, "맛있어보이는 사과이다.", false, "슬라임, 고블린, 대왕슬라임, 홉고블린, 산성슬라임, 킹고블린", 200));
        user.getItemsList().add(new Item("맛있는 사과", "포션", 0, 0, 0, 0, 20, 0, 10, 0, "더 더  맛있어보이는 사과이다.", false, "흑랑, 세이렌, 거대 골렘", 500));

    }

}
