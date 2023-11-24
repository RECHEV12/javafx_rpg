package com.example.rpg.controller;

import com.example.rpg.GameUtillMethod;
import com.example.rpg.monster.Monster;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

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
    private ProgressBar monsterHpBar;
    @FXML
    private ImageView monsterImg;

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
    private VBox battleLog;

    int logCounter = 1;
    int mobMaxHP = 0;
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

        userName.setText(user.getPlayerName());
        setUserHp();
        setUserMp();










/*        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> addLog())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();*/
    }

/*    private void addLog() {
        Label logLabel = new Label("Game Log #" + logCounter++);
        battleLog.getChildren().add(logLabel);
    }*/

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

}
