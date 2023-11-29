package com.example.rpg.controller;

import com.example.rpg.item.Item;
import com.example.rpg.monster.Monster;
import com.example.rpg.skill.Skill;
import com.example.rpg.skill.SkillDB;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;

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
import static com.example.rpg.UsefullMethod.*;

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
    private Label userLv;
    @FXML
    private ProgressBar userHpBar;
    @FXML
    private ProgressBar userMpBar;
    @FXML
    private ProgressBar userExpBar;
    @FXML
    private Label userHpLabel;
    @FXML
    private Label userMpLabel;
    @FXML
    private Label userExpLabel;
    @FXML
    private HBox skillTab;
    @FXML
    private HBox itemTab;
    @FXML
    private ImageView userDice;

    @FXML
    private Label Battle;
    @FXML
    private VBox battleLog;

    int mobMaxHP = 0;
    int mobDmgTotal = 0;
    int userDmgTotal = 0;
    int nowTurn = 1;
    int monsterDiceNum = 1;
    int playerDiceNum = 1;

    ArrayList<Skill> monsterSkillList = new ArrayList<>();
    ArrayList<Skill> allSkillList = SkillDB.getInstance().getSkillList();


    public void setMob() {
        String mobName;
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
            mobName = "레어 개체 : " + nowMob.getMonsterName();
        }
        monsterName.setText(mobName);
        monsterWeak.setText("약점 : " + nowMob.getMonsterType());

    }

    @FXML
    public void showMonster() {
        nowTurn = 1;
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
        userLv.setText(user.getLv() +"");
        setUserHp();
        setUserMp();
        setUserExp();
        setUserSkill();
        setUserItem();
    }

    public void runBattle() {
        nowMob = new Monster();
        goReady(monsterHpLabel);
    }

    @FXML
    public void doBattle() {
        if (user.getStatNowHP() == 0) {
            changeHome(monsterHpLabel);
            nowMob = new Monster();
        }
        if (nowMob.getMonsterHP() == 0) {
            nowTurn = 1;
            goBattleRst(monsterHpLabel);
        } else {
            Skill nowSkill = monsterChoiceSkill(monsterSkillList);
            mobSkillName.setText(nowSkill.getSkillName());
            mobDmgTotal = getMonsterDamage(nowSkill, nowMob);
            mobSkillDmg.setText("예상 대미지 : " + mobDmgTotal);

            monsterDiceNum = makeRandom(1, 6);
            String mobDice = "/images/" + monsterDiceNum + ".jpg";
            Image mobImg = new Image(Objects.requireNonNull(getClass().getResource(mobDice)).toExternalForm());
            monsterDice.setImage(mobImg);
            Battle.setDisable(true);

            Label cutLineLabel = new Label();
            Label showTurnLabel = new Label();
            Label monsterDiceTurnLabel = new Label();

            cutLineLabel.setText("-----------------------------------------------------------");
            showTurnLabel.setText("현재 : " + nowTurn + "턴");
            monsterDiceTurnLabel.setText(nowMob.getMonsterName() + "의 행동 속도는 " + monsterDiceNum + "!!");

            ArrayList<Label> doBattleLog = new ArrayList<>();
            doBattleLog.add(cutLineLabel);
            doBattleLog.add(showTurnLabel);
            doBattleLog.add(monsterDiceTurnLabel);
            logAdd(doBattleLog);

            nowTurn++;
        }
    }


    public void setMobHp() {
        double monsterHpBarNum = (double) nowMob.getMonsterHP() / mobMaxHP;
        if (monsterHpBarNum <= 0) {
            monsterHpBarNum = 0;
        }

        Timeline timeline = new Timeline();

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(monsterHpBar.progressProperty(), monsterHpBarNum));

        timeline.getKeyFrames().add(keyFrame);

        timeline.play();

        monsterHpLabel.setText(nowMob.getMonsterHP() + "/" + mobMaxHP);

    }

    public void setUserHp() {
        double userHpBarNum = (double) user.getStatNowHP() / user.getStatMaxHP();
        if (userHpBarNum <= 0) {
            userHpBarNum = 0;
        }

        Timeline timeline = new Timeline();

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(userHpBar.progressProperty(), userHpBarNum));

        timeline.getKeyFrames().add(keyFrame);

        timeline.play();

        userHpLabel.setText(user.getStatNowHP() + "/" + user.getStatMaxHP());

    }

    public void setUserExp() {
        double userExpBarNum = (double) user.getExp() / user.getNextExp();
        if (userExpBarNum <= 0) {
            userExpBarNum = 0;
        }

        Timeline timeline = new Timeline();

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(userExpBar.progressProperty(), userExpBarNum));

        timeline.getKeyFrames().add(keyFrame);

        timeline.play();

        userExpLabel.setText(user.getExp() + "/" + user.getNextExp());


    }

    public void setUserMp() {
        double userMpBarNum = (double) user.getStatNowMP() / user.getStatMaxMP();
        if (userMpBarNum <= 0) {
            userMpBarNum = 0;
        }
        Timeline timeline = new Timeline();

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(userMpBar.progressProperty(), userMpBarNum));

        timeline.getKeyFrames().add(keyFrame);

        timeline.play();

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
            button.setOnAction(event -> userItem(item));

            mainSet.getChildren().addAll(itemName, secondBox, button);
            itemTab.getChildren().add(mainSet);
        }


    }

    public void userItem(Item item) {

        ArrayList<Label> temp = new ArrayList<>();

        user.setStatMaxHP(user.getStatMaxHP() + item.getPlusMaxHP());
        user.setStatMaxMP(user.getStatMaxMP() + item.getPlusMaxMP());

        if (user.getStatNowHP() + item.getPlusNowHP() >= user.getStatMaxHP()) {
            user.setStatNowHP(user.getStatMaxHP());
        } else {
            user.setStatNowHP(user.getStatNowHP() + item.getPlusNowHP());
        }

        if (user.getStatNowMP() + item.getPlusNowMP() >= user.getStatMaxMP()) {
            user.setStatNowMP(user.getStatMaxMP());
        } else {

            user.setStatNowMP(user.getStatNowMP() + item.getPlusNowMP());
        }
        user.getItemsList().remove(item);
        Label itemName = new Label();
        itemName.setText(user.getPlayerName() + "은(는) " + item.getItemName() + "을(를) 사용했다!");

        Label logA = new Label();
        temp.add(itemName);
        temp.add(logA);

        logA.setText(user.getPlayerName() + "은(는) " + mobDmgTotal + "의 대미지를 입었다.");
        user.setStatNowHP(user.getStatNowHP() - mobDmgTotal);

        listFilterAndAdd(temp);
        setUserHp();
        setUserMp();
        itemTab.getChildren().clear();
        setUserItem();
    }

    public void movePlayer(Skill skill) {
        if (user.getStatNowMP() < skill.getUseMp()) {
            showAlertErr("마나가 부족합니다.");
            return;
        }
        user.setStatNowMP(user.getStatNowMP() - skill.getUseMp());
        setUserMp();
        ArrayList<Label> movePlayerLabelList = new ArrayList<>();

        if (skill.getSkillType().equals("방어")) {
            int defDamage = defDamage(user, skill);
            Label logA = new Label();
            Label logB = new Label();
            Label logG = new Label();

            logA.setText(skill.getSkillName() + "은(는)" + defDamage + "대미지를 방어할 수 있다!");

            if (defDamage >= mobDmgTotal) {
                logB.setText(user.getPlayerName() + "은(는) 모든 대미지를 방어했다.");

            } else {
                logB.setText(user.getPlayerName() + "은(는) " + (mobDmgTotal - defDamage) + "의 대미지를 입었다.");
                user.setStatNowHP(user.getStatNowHP() - (mobDmgTotal - defDamage));
                if (user.getStatNowHP() <= 0) {
                    user.setStatNowHP(0);
                    user.setExp(0);
                    logG.setText("죽었습니다. 경험치가 0이 되고, 마을로 돌아갑니다.");
                    listFilterAndAdd(movePlayerLabelList);
                }
                setUserHp();
            }
            movePlayerLabelList.add(logA);
            movePlayerLabelList.add(logB);
            movePlayerLabelList.add(logG);
            listFilterAndAdd(movePlayerLabelList);


        } else {
            userDmgTotal = getUserDamage(user, skill, nowMob);

            playerDiceNum = makeRandom(1, 6);
             playerDiceNum = playerDiceNum + makeRandomLuk(user.getStatLUK());
             if (playerDiceNum>6){
                 playerDiceNum = 6;
             }

            String mobDice = "/images/" + playerDiceNum + ".jpg";
            Image mobImg = new Image(Objects.requireNonNull(getClass().getResource(mobDice)).toExternalForm());
            userDice.setImage(mobImg);
            Label logA = new Label();
            Label logB = new Label();
            Label logC = new Label();
            Label logD = new Label();
            Label logE = new Label();
            Label logF = new Label();
            Label logG = new Label();
            Label logH = new Label();
            movePlayerLabelList.add(logA);
            movePlayerLabelList.add(logB);
            movePlayerLabelList.add(logC);
            movePlayerLabelList.add(logD);
            movePlayerLabelList.add(logE);
            movePlayerLabelList.add(logF);
            movePlayerLabelList.add(logG);
            movePlayerLabelList.add(logH);
            logA.setText(user.getPlayerName() + "의 행동 속도는 " + playerDiceNum + "!!");
            logH.setText("턴 종료. 다음턴으로 넘어갑니다");
            if (playerDiceNum >= monsterDiceNum) {
                logB.setText(user.getPlayerName() + "의 선공!");
                attackFromPlayer(nowMob, userDmgTotal, logC, logD);
                if (nowMob.getMonsterHP() == 0) {
                    logG.setText(nowMob.getMonsterName() + "을(를) 쓰러뜨렸습니다!");

                    listFilterAndAdd(movePlayerLabelList);

                } else {
                    attackFromMob(nowMob, logE, logF);
                    if (user.getStatNowHP() == 0) {
                        user.setExp(0);
                        logG.setText("죽었습니다. 경험치가 0이 되고, 마을로 돌아갑니다.");
                    }
                    listFilterAndAdd(movePlayerLabelList);

                }
            } else {
                logB.setText(nowMob.getMonsterName() + "의 선공!");
                attackFromMob(nowMob, logC, logD);
                if (user.getStatNowHP() == 0) {
                    user.setExp(0);
                    logG.setText("죽었습니다. 경험치가 0이 되고, 마을로 돌아갑니다.");
                    listFilterAndAdd(movePlayerLabelList);
                } else {
                    attackFromPlayer(nowMob, userDmgTotal, logE, logF);
                    if (nowMob.getMonsterHP() == 0) {
                        logG.setText(nowMob.getMonsterName() + "을(를) 쓰러뜨렸습니다!");
                    }
                    listFilterAndAdd(movePlayerLabelList);
                }
            }

        }

    }

    public void attackFromPlayer(Monster mob, int dmg, Label a, Label b) {
        int result = 0;

        if (!(mob.getMonsterHP() - dmg <= 0)) {
            result = mob.getMonsterHP() - dmg;
        }
        mob.setMonsterHP(result);
        setMobHp();
        a.setText(user.getPlayerName() + "의 " + dmg + "대미지!!");
        b.setText(mob.getMonsterName() + "은(는) " + dmg + "대미지를 입어 체력이 " + mob.getMonsterHP() + "이(가) 되었다!");
    }

    public void attackFromMob(Monster mob, Label a, Label b) {
        int result = 0;
        if (!(user.getStatNowHP() - mobDmgTotal <= 0)) {
            result = user.getStatNowHP() - mobDmgTotal;
        }
        user.setStatNowHP(result);
        setUserHp();
        a.setText(mob.getMonsterName() + "의 " + mobDmgTotal + "대미지!!");
        b.setText(user.getPlayerName() + "은(는) " + mobDmgTotal + "의 대미지를 입어 체력이 " + user.getStatNowHP() + "이(가) 되었다.");
    }

    public void listFilterAndAdd(ArrayList<Label> list) {
        ArrayList<Label> filteredList = new ArrayList<>();

        for (Label label : list) {
            if (!label.getText().isEmpty()) {
                filteredList.add(label);
            }
        }

        logAdd(filteredList);
    }

    public void logAdd(ArrayList<Label> logList) {

        Timeline timeline = new Timeline();

        for (int i = 0; i < logList.size(); i++) {
            final int index = i;

            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i + 1), event -> {
                battleLog.getChildren().add(logList.get(index));
            });

            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(event -> {
            if (!logList.isEmpty() && !logList.get(0).getText().equals("-----------------------------------------------------------")) {
                doBattle();
            }

        });

        timeline.play();

    }
}


