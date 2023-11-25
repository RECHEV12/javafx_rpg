package com.example.rpg.controller;

import com.example.rpg.character.LevelDB;
import com.example.rpg.item.Item;
import com.example.rpg.monster.Monster;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;

import static com.example.rpg.GameUtillMethod.*;
import static com.example.rpg.GameUtillMethod.user;
import static com.example.rpg.UsefullMethod.*;

public class BattleResultController {
    @FXML
    private Label label;
    @FXML
    private Label nowLv;
    @FXML
    private Label userExpLabel;
    @FXML
    private VBox expLog;

    @FXML
    private ProgressBar userExpBar;






    public void setUserExp() {
        double userExpBarNum = (double) user.getExp() / user.getNextExp();
        Timeline timeline = new Timeline();


        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(userExpBar.progressProperty(), userExpBarNum));

        timeline.getKeyFrames().add(keyFrame);

        timeline.play();

        userExpLabel.setText(user.getExp() + "/" + user.getNextExp());


    }

    @FXML
    public void endBattle() {
//        todo 각종 데이터 리셋
        ArrayList<Label> temp = new ArrayList<>();

        Label expLabel = new Label();
        Label lvUpLabel = new Label();
        Label getSkillLabel = new Label();
        Label moneyLabel = new Label();
        Label itemLabel = new Label();

        temp.add(expLabel);
        temp.add(lvUpLabel);
        temp.add(getSkillLabel);
        temp.add(moneyLabel);
        temp.add(itemLabel);

        if (user.getLv() < 40) {

            int exp = getExp(nowMob, isRare);
            user.setExp(user.getExp() + exp);

            setUserExp();

            expLabel.setText("경험치를 " + exp + " 획득하였습니다!");
            if (user.getExp() >= user.getNextExp()) {
                System.out.println(user.getPlayerClass());
                levelUP(user);
                user.setExp(user.getExp() - user.getNextExp());
                user.setNextExp(getNextExp(user.getLv()));

                user.setLv(user.getLv() + 1);
                lvUpLabel.setText(user.getPlayerName() + "의 레벨이 " + user.getLv() + "이 되었습니다.");
                getSkillLabel.setText(userAddSkill(user).getText());
            }
            setUserExp();

        }
        // 돈 드랍 기믹
        int money = getMoney(nowMob, isRare);
        user.setMoney(user.getMoney() + money);
        moneyLabel.setText(money + "원을 획득했다!" + " | 현재 소지금 : " + user.getMoney());

        // 아이템 드랍
        Item nowDropItem = dropItem(nowMob);

        if (!(nowDropItem.getItemName() == null)) {
            user.getItemsList().add(nowDropItem);
            itemLabel.setText(nowDropItem.getItemName() + "을(를) 획득했다!!");
        }
        nowLv.setText("Lv. " + user.getLv());

        for (Label lab : temp){
            lab.setFont(new Font(nowLv.getFont().getSize()));
        }
        listFilterAndAdd(temp);
    }

    @FXML
    public void goAllField() {
        goField(label);
        nowMob = new Monster();
    }

    @FXML
    public void goingField() {
        goReady(label);
        nowMob = new Monster();
    }

    @FXML
    public void goHome() {
        changeHome(label);
        nowMob = new Monster();
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
        System.out.println(logList);
        Timeline timeline = new Timeline();

        for (int i = 0; i < logList.size(); i++) {
            final int index = i;

            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i + 1), event -> {
                expLog.getChildren().add(logList.get(index));
            });

            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();

    }

}
