package com.example.rpg.controller;

import com.example.rpg.HelloApplication;
import com.example.rpg.GameUtillMethod;
import com.example.rpg.character.Class;
import com.example.rpg.skill.Skill;
import com.example.rpg.skill.SkillDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.rpg.GameUtillMethod.selectedClass;
import static com.example.rpg.GameUtillMethod.user;

public class IntroController {
    @FXML
    private ToggleButton selectWarrior;
    @FXML
    private ToggleButton selectMagician;
    @FXML
    private Label title;
    @FXML
    private TextField inputName;

    ArrayList<Skill> playerSkillList = SkillDB.getInstance().getplayerSkillList();

    @FXML
    protected void goMain() {

        if (selectWarrior.isSelected()) {
            GameUtillMethod.selectedClass = "전사";
        } else {
            GameUtillMethod.selectedClass = "마법사";
        }

        if (selectedClass.equals("전사")) {
            user = Class.warrior;
        } else {
            user = Class.magician;
        }

        GameUtillMethod.user.setPlayerName(inputName.getText());


        for (Skill skill : playerSkillList) {
            if (skill.getClassType().equals(selectedClass) &&
                    skill.getLearnLevel() == 1) {
                user.getPlayerSkillList().add(skill);
            }
        }

        Stage stage = (Stage) title.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            MainController mc = fxmlLoader.getController();
            mc.startGame();
            stage.setScene(scene);
            stage.setTitle("main");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}