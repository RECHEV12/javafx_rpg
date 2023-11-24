package com.example.rpg.controller;

import com.example.rpg.GameUtillMethod;
import com.example.rpg.item.Item;
import com.example.rpg.monster.Monster;
import com.example.rpg.skill.Skill;
import com.example.rpg.skill.SkillDB;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.rpg.GameUtillMethod.*;
import static com.example.rpg.UsefullMethod.changeHome;
import static com.example.rpg.UsefullMethod.goBack;

public class BattleController {

    @FXML
    private Label monsterName;
    @FXML
    private Label monsterLv;
    @FXML
    private Label monsterHpLabel;
    @FXML
    private Label monsterWeak;
    @FXML
    private ProgressBar monsterHpBar;
    @FXML
    private ImageView monsterImg;
    @FXML
    private ImageView monsterDice;
    @FXML
    private Label mobSkillName;
    @FXML
    private Label mobSkillDmg;

    @FXML
    private Label userName;
    @FXML
    private ProgressBar userHpBar;
    @FXML
    private ProgressBar userMpBar;
    @FXML
    private Label userHpLabel;
    @FXML
    private Label userMpLabel;
    @FXML
    private ScrollPane scroll;
    @FXML
    private HBox skillTab;
    @FXML
    private HBox itemTab;

    @FXML
    private Label Battle;
    @FXML
    private VBox battleLog;

    int mobMaxHP = 0;
    int mobDmgTotal = 0;

    ArrayList<Skill> monsterSkillList = new ArrayList<>();
    ArrayList<Skill> allSkillList = SkillDB.getInstance().getSkillList();


    int logCounter = 1;
    Label temp = new Label();

    @FXML
    public void showMonster() {
        setMob();
        monsterLv.setText("Lv." + nowMob.getMonsterLv());

        mobMaxHP = nowMob.getMonsterHP();
        setMobHp();

        String mobImgRoot = "/images/" + nowMob.getMonsterName() + ".jpg";
        Image mobImg = new Image(Objects.requireNonNull(getClass().getResource(mobImgRoot)).toExternalForm());
        monsterImg.setImage(mobImg);

        for (Skill skill : allSkillList) {
            if (skill.getClassType().equals(nowMob.getMonsterName())) {
                monsterSkillList.add(skill);
            }
        }


        userName.setText(user.getPlayerName());
        setUserHp();
        setUserMp();
        setUserSkill();
        setUserItem();
    }

    @FXML
    public void doBattle() {
        Skill nowSkill = monsterChoiceSkill(monsterSkillList);
        mobSkillName.setText(nowSkill.getSkillName());
        mobDmgTotal = getMonsterDamage(nowSkill, nowMob);
        mobSkillDmg.setText("예상 대미지 : " + mobDmgTotal);
        int monsterDiceNum = makeRandom(1, 6);

        String mobDice = "/images/" + monsterDiceNum + ".jpg";
        Image mobImg = new Image(Objects.requireNonNull(getClass().getResource(mobDice)).toExternalForm());
        monsterDice.setImage(mobImg);
        Battle.setDisable(true);

    }

    @FXML
    public void endBattle() {
        //todo 각종 데이터 리셋
    }

//    private static void performAction() {
//        boolean actionExecuted = false;
//        // Perform some action
//        if (actionExecuted) {
//            return;
//        }
//
//        // Mark the action as executed
//
//        // Create a 1-second pause
//        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(3));
//        pauseTransition.setOnFinished(event -> {
//            // Code to be executed after the 1-second pause
//            System.out.println("After 1-second pause: Action completed!");
//        });
//
//        // Start the pause transition
//        pauseTransition.play();
//        actionExecuted = true;
//    }

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
        monsterWeak.setText("약점 : " + nowMob.getMonsterType());

    }

    public void setMobHp() {
        double monsterHpBarNum = (double) nowMob.getMonsterHP() / mobMaxHP;
        monsterHpBar.setProgress(monsterHpBarNum);
        monsterHpLabel.setText(nowMob.getMonsterHP() + "/" + mobMaxHP);

    }

    public void setUserHp() {
        double userHpBarNum = (double) user.getStatNowHP() / user.getStatMaxHP();
        userHpBar.setProgress(userHpBarNum);
        userHpLabel.setText(user.getStatNowHP() + "/" + user.getStatMaxHP());

    }

    public void setUserMp() {
        double userMpBarNum = (double) user.getStatNowMP() / user.getStatMaxMP();
        userMpBar.setProgress(userMpBarNum);
        userMpLabel.setText(user.getStatNowMP() + "/" + user.getStatMaxMP());

    }

    public void setUserSkill() {
        double scrollWith = 200;

        for (Skill skill : user.getPlayerSkillList()) {

            Insets inset = new Insets(10);
            BorderStroke stroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 2, 2, 2));
            BorderStroke strokeA = new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 0, 2, 0));
            Border border = new Border(stroke);
            Border borderA = new Border(strokeA);

            VBox mainSet = new VBox();
            mainSet.setPrefWidth(scrollWith);
            mainSet.setPadding(inset);
            mainSet.setBorder(border);
            mainSet.setAlignment(Pos.CENTER);

            Label skillName = new Label();
            skillName.setText("이름 : " + skill.getSkillName());
            skillName.setAlignment(Pos.CENTER);

            HBox typeMp = new HBox();
            typeMp.setPadding(inset);
            typeMp.setPrefWidth(mainSet.getPrefWidth());


            Label skillType = new Label();
            skillType.setText("타입 : " + skill.getSkillType());
            skillType.setAlignment(Pos.CENTER);
            skillType.setPrefWidth(typeMp.getPrefWidth() / 2);

            Label skillMp = new Label();
            skillMp.setText("마나 : " + skill.getUseMp());
            skillMp.setAlignment(Pos.CENTER);
            skillMp.setPrefWidth(typeMp.getPrefWidth() / 2);

            typeMp.getChildren().addAll(skillType, skillMp);

            VBox parameter = new VBox();
            parameter.setBorder(borderA);
            parameter.setPadding(inset);
            parameter.setPrefWidth(mainSet.getPrefWidth());
            parameter.setAlignment(Pos.CENTER);

            Label skillSTR = new Label();
            skillSTR.setText("STR : " + skill.getPerStr() + "%");
            skillSTR.setAlignment(Pos.CENTER);

            Label skillDEX = new Label();
            skillDEX.setText("DEX : " + skill.getPerDex() + "%");
            skillDEX.setAlignment(Pos.CENTER);

            Label skillINT = new Label();
            skillINT.setText("INT : " + skill.getPerInt() + "%");
            skillINT.setAlignment(Pos.CENTER);

            parameter.getChildren().addAll(skillSTR, skillDEX, skillINT);

            Button button = new Button();
            button.setText("사용");
            button.setPrefWidth(typeMp.getPrefWidth());
            button.setAlignment(Pos.CENTER);
            button.setOnAction(event -> movePlayer(skill));

            mainSet.getChildren().addAll(skillName, typeMp, parameter, button);

            skillTab.getChildren().add(mainSet);
        }
        System.out.println(skillTab.getPrefWidth());
        System.out.println(skillTab.getPrefHeight());
    }

    public void setUserItem() {
        double scrollWith = 200;
        Insets inset = new Insets(5);

        BorderStroke stroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 2, 2, 2));
        BorderStroke strokeA = new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 0, 2, 0));
        BorderStroke strokeB = new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(0, 2, 0, 2));
        Border border = new Border(stroke);
        Border borderA = new Border(strokeA);
        Border borderB = new Border(strokeB);

        for (Item item : user.getItemsList()) {
            if (!item.getItemType().equals("포션")) {
                continue;
            }
            VBox mainSet = new VBox();
            mainSet.setPrefWidth(scrollWith);
            mainSet.setPadding(inset);
            mainSet.setBorder(border);
            mainSet.setAlignment(Pos.CENTER);


            Label itemName = new Label();
            itemName.setText("이름 : " + item.getItemName());
            itemName.setAlignment(Pos.CENTER);

            VBox secondBox = new VBox();
            secondBox.setPrefWidth(scrollWith - 5);
            secondBox.setBorder(borderB);
            secondBox.setPadding(inset);


            HBox setHP = new HBox();
            setHP.setPadding(inset);
            setHP.setPrefWidth(secondBox.getPrefWidth());
            setHP.setBorder(borderA);

            HBox setMP = new HBox();
            setMP.setPadding(inset);
            setMP.setPrefWidth(secondBox.getPrefWidth());
            setMP.setBorder(borderA);


            Label nowHP = new Label();
            nowHP.setText("HP + " + item.getPlusNowHP());
            nowHP.setPrefWidth(setHP.getPrefWidth() / 2);
            nowHP.setAlignment(Pos.CENTER);

            Label maxHP = new Label();
            maxHP.setText("M.HP + " + item.getPlusMaxHP());
            maxHP.setPrefWidth(setHP.getPrefWidth() / 2);
            maxHP.setAlignment(Pos.CENTER);

            Label nowMP = new Label();
            nowMP.setText("MP + " + item.getPlusNowMP());
            nowMP.setPrefWidth(setMP.getPrefWidth() / 2);
            nowMP.setAlignment(Pos.CENTER);

            Label maxMP = new Label();
            maxMP.setText("M.MP + " + item.getPlusMaxMP());
            maxMP.setPrefWidth(setMP.getPrefWidth() / 2);
            maxMP.setAlignment(Pos.CENTER);

            setHP.getChildren().addAll(nowHP, maxHP);
            setMP.getChildren().addAll(nowMP, maxMP);
            secondBox.getChildren().addAll(setHP, setMP);

            Button button = new Button();
            button.setText("사용");
            button.setPrefWidth(setMP.getPrefWidth());
            button.setAlignment(Pos.CENTER);

            mainSet.getChildren().addAll(itemName, secondBox, button);
            itemTab.getChildren().add(mainSet);
        }
        System.out.println(itemTab.getPrefWidth());
        System.out.println(itemTab.getPrefHeight());
    }

    public void movePlayer(Skill skill) {
        if (skill.getSkillType().equals("방어")) {
            int defDamage = defDamage(user, skill);


            Label logA = new Label();
            if (defDamage >= mobDmgTotal) {
                logA.setText(user.getPlayerName() + "은(는) 모든 대미지를 방어했다.");
                System.out.println(logA.getText());
//logA추가 -> 턴 종료
            } else {
                logA.setText(defDamage + "대미지 방어 | " + user.getPlayerName() + "은(는) " + (mobDmgTotal - defDamage) + "의 대미지를 입었다.");
                user.setStatNowHP(user.getStatNowHP()-(mobDmgTotal - defDamage));
                setUserHp();
//logA추가 -> 대미지 계산 후 -> 턴종료
            }

        } else {

        }

        doBattle();
    }
}
