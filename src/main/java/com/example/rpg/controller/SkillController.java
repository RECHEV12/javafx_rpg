package com.example.rpg.controller;

import com.example.rpg.skill.Skill;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static com.example.rpg.GameUtillMethod.user;
import static com.example.rpg.UsefullMethod.changeHome;
import static com.example.rpg.UsefullMethod.goBack;

public class SkillController {
    @FXML
    private VBox showSkillList;
    @FXML
    private Label label;

    @FXML
    public void showSkill() {
        ArrayList<Skill> skillList = user.playerSkillList;
        for (Skill skill : skillList) {

            Insets inset = new Insets(10);
            BorderStroke stroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 2, 2, 2));
            BorderStroke strokeA = new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 0, 2, 0));
            Border border = new Border(stroke);
            Border borderA = new Border(strokeA);


            VBox skillStatus = new VBox();
            skillStatus.setBorder(border);
            skillStatus.setPadding(inset);

            HBox skillETC = new HBox();
            skillETC.setPrefWidth(showSkillList.getPrefWidth());
            skillETC.setBorder(borderA);
            skillETC.setPadding(inset);

            HBox skillParameter = new HBox();
            skillParameter.setPrefWidth(showSkillList.getPrefWidth());
            skillParameter.setBorder(borderA);
            skillParameter.setPadding(inset);


            HBox skillInfo = new HBox();
            skillInfo.setPrefWidth(showSkillList.getPrefWidth());
            skillInfo.setBorder(borderA);
            skillInfo.setPadding(inset);

            skillStatus.getChildren().addAll(skillETC, skillParameter, skillInfo);

            Label skillName = new Label();
            skillName.setText("스킬명 : " + skill.getSkillName());
            skillName.setPrefWidth(skillETC.getPrefWidth() / 4);
            skillName.setAlignment(Pos.CENTER);

            Label skillType = new Label();
            skillType.setText("스킬 타입 : " + skill.getSkillType());
            skillType.setPrefWidth(skillETC.getPrefWidth() / 4);
            skillType.setAlignment(Pos.CENTER);

            Label skillLearnLV = new Label();
            skillLearnLV.setText("습득 레벨 : " + skill.getLearnLevel());
            skillLearnLV.setPrefWidth(skillETC.getPrefWidth() / 4);
            skillLearnLV.setAlignment(Pos.CENTER);

            Label skillMP = new Label();
            skillMP.setText("소비 MP : " + skill.getUseMp());
            skillMP.setPrefWidth(skillETC.getPrefWidth() / 4);
            skillMP.setAlignment(Pos.CENTER);

            skillETC.getChildren().addAll(skillName, skillType, skillLearnLV, skillMP);

            Label skillSTR = new Label();
            skillSTR.setText("STR : " + skill.getPerStr() + "%");
            skillSTR.setPrefWidth(skillParameter.getPrefWidth() / 3);
            skillSTR.setAlignment(Pos.CENTER);

            Label skillINT = new Label();
            skillINT.setText("INT : " + skill.getPerInt() + "%");
            skillINT.setPrefWidth(skillParameter.getPrefWidth() / 3);
            skillINT.setAlignment(Pos.CENTER);

            Label skillDEX = new Label();
            skillDEX.setText("DEX : " + skill.getPerDex() + "%");
            skillDEX.setPrefWidth(skillParameter.getPrefWidth() / 3);
            skillDEX.setAlignment(Pos.CENTER);

            skillParameter.getChildren().addAll(skillSTR, skillINT, skillDEX);

            Label skillDesc = new Label();
            skillDesc.setText(skill.getSkillInfo());
            skillInfo.getChildren().add(skillDesc);


            showSkillList.getChildren().add(skillStatus);

        }
    }
    @FXML
    public void backStage(){
        goBack(label);
    }
    @FXML
    public void goHome(){
        changeHome(label);
    }
}
