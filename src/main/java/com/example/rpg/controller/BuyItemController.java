package com.example.rpg.controller;


import com.example.rpg.UsefullMethod;
import com.example.rpg.item.Item;
import javafx.fxml.FXML;


import javafx.scene.control.Label;
import javafx.stage.Stage;




import static com.example.rpg.GameUtillMethod.user;

public class BuyItemController {
    @FXML
    private Label plusSTR;
    @FXML
    private Label plusDEX;
    @FXML
    private Label plusINT;
    @FXML
    private Label plusLUK;
    @FXML
    private Label plusHP;
    @FXML
    private Label plusMP;
    @FXML
    private Label plusMAXHP;
    @FXML
    private Label plusMAXMP;

    static int nowHpRst;
    static int nowMpRst;
    Item nowItem = new Item();

    @FXML
    public void showUpStat(Item item) {
        nowItem = item;
        if (item.getItemType().equals("포션")) {
            plusSTR.setText(user.getStatSTR() + "(+" + item.getPlusSTR() + ") = " + (user.getStatSTR() + item.getPlusSTR()));
            plusDEX.setText(user.getStatDEX() + "(+" + item.getPlusDEX() + ") = " + (user.getStatDEX() + item.getPlusDEX()));
            plusINT.setText(user.getStatINT() + "(+" + item.getPlusINT() + ") = " + (user.getStatINT() + item.getPlusINT()));
            plusLUK.setText(user.getStatLUK() + "(+" + item.getPlusLUK() + ") = " + (user.getStatLUK() + item.getPlusLUK()));
            calRst(user.getStatNowHP() + item.getPlusNowHP(), user.getStatNowMP() + item.getPlusNowMP());
            plusHP.setText(user.getStatNowHP() + "(+" + item.getPlusNowHP() + ") = " + nowHpRst);
            plusMP.setText(user.getStatNowMP() + "(+" + item.getPlusNowMP() + ") = " + nowMpRst);
            plusMAXHP.setText(user.getStatMaxHP() + "(+" + item.getPlusMaxHP() + ") = " + (user.getStatMaxHP() + item.getPlusMaxHP()));
            plusMAXMP.setText(user.getStatMaxMP() + "(+" + item.getPlusMaxMP() + ") = " + (user.getStatMaxMP() + item.getPlusMaxMP()));
        } else {
            if (item.getItemType().equals("무기")) {
                calRst(user.getStatNowHP() + item.getPlusNowHP() - user.getWeapon().getPlusNowHP(), user.getStatNowMP() + item.getPlusNowMP() - user.getWeapon().getPlusNowMP());
                plusSTR.setText((user.getStatSTR() + "-" + user.getWeapon().getPlusSTR()) + "(+" + item.getPlusSTR() + ") = " + (user.getStatSTR() + item.getPlusSTR() - user.getWeapon().getPlusSTR()));
                plusDEX.setText((user.getStatDEX() + "-" + user.getWeapon().getPlusDEX()) + "(+" + item.getPlusDEX() + ") = " + (user.getStatDEX() + item.getPlusDEX() - user.getWeapon().getPlusDEX()));
                plusINT.setText((user.getStatINT() + "-" + user.getWeapon().getPlusINT()) + "(+" + item.getPlusINT() + ") = " + (user.getStatINT() + item.getPlusINT() - user.getWeapon().getPlusINT()));
                plusLUK.setText((user.getStatLUK() + "-" + user.getWeapon().getPlusLUK()) + "(+" + item.getPlusLUK() + ") = " + (user.getStatLUK() + item.getPlusLUK() - user.getWeapon().getPlusLUK()));
                plusHP.setText((user.getStatNowHP() + "-" + user.getWeapon().getPlusNowHP()) + "(+" + item.getPlusNowHP() + ") = " + nowHpRst);
                plusMP.setText((user.getStatNowMP() + "-" + user.getWeapon().getPlusNowMP()) + "(+" + item.getPlusNowMP() + ") = " + nowMpRst);
                plusMAXHP.setText((user.getStatMaxHP() + "-" + user.getWeapon().getPlusMaxHP()) + "(+" + item.getPlusMaxHP() + ") = " + (user.getStatMaxHP() + item.getPlusMaxHP() - user.getWeapon().getPlusMaxHP()));
                plusMAXMP.setText((user.getStatMaxMP() + "-" + user.getWeapon().getPlusMaxMP()) + "(+" + item.getPlusMaxMP() + ") = " + (user.getStatMaxMP() + item.getPlusMaxMP() - user.getWeapon().getPlusMaxMP()));
            } else if (item.getItemType().equals("방어구")) {
                calRst(user.getStatNowHP() + item.getPlusNowHP() - user.getEquip().getPlusNowHP(), user.getStatNowMP() + item.getPlusNowMP() - user.getEquip().getPlusNowMP());
                plusSTR.setText((user.getStatSTR() + "-" + user.getEquip().getPlusSTR()) + "(+" + item.getPlusSTR() + ") = " + (user.getStatSTR() + item.getPlusSTR() - user.getEquip().getPlusSTR()));
                plusDEX.setText((user.getStatDEX() + "-" + user.getEquip().getPlusDEX()) + "(+" + item.getPlusDEX() + ") = " + (user.getStatDEX() + item.getPlusDEX() - user.getEquip().getPlusDEX()));
                plusINT.setText((user.getStatINT() + "-" + user.getEquip().getPlusINT()) + "(+" + item.getPlusINT() + ") = " + (user.getStatINT() + item.getPlusINT() - user.getEquip().getPlusINT()));
                plusLUK.setText((user.getStatLUK() + "-" + user.getEquip().getPlusLUK()) + "(+" + item.getPlusLUK() + ") = " + (user.getStatLUK() + item.getPlusLUK() - user.getEquip().getPlusLUK()));
                plusHP.setText((user.getStatNowHP() + "-" + user.getEquip().getPlusNowHP()) + "(+" + item.getPlusNowHP() + ") = " + nowHpRst);
                plusMP.setText((user.getStatNowMP() + "-" + user.getEquip().getPlusNowMP()) + "(+" + item.getPlusNowMP() + ") = " + nowMpRst);
                plusMAXHP.setText((user.getStatMaxHP() + "-" + user.getEquip().getPlusMaxHP()) + "(+" + item.getPlusMaxHP() + ") = " + (user.getStatMaxHP() + item.getPlusMaxHP() - user.getEquip().getPlusMaxHP()));
                plusMAXMP.setText((user.getStatMaxMP() + "-" + user.getEquip().getPlusMaxMP()) + "(+" + item.getPlusMaxMP() + ") = " + (user.getStatMaxMP() + item.getPlusMaxMP() - user.getEquip().getPlusMaxMP()));

            }
        }

    }


    protected static void calRst(int hp, int mp) {
        if (hp > user.getStatMaxHP()) {
            nowHpRst = user.getStatMaxHP();
        } else {
            nowHpRst = hp;
        }
        if (mp > user.getStatMaxMP()) {
            nowMpRst = user.getStatMaxMP();
        } else {
            nowMpRst = mp;

        }
    }

    @FXML
    protected void buyItem() {

        if (user.getMoney() - (nowItem.getPrice()*2) < 0) {
            UsefullMethod.showAlertErr("돈이 부족합니다.");
        } else {
            user.getItemsList().add(nowItem);
            user.setMoney(user.getMoney() - (nowItem.getPrice()*2));
        }
        Stage stageA = (Stage) plusHP.getScene().getWindow();
        stageA.close();


    }

    @FXML
    protected void closed() {
        Stage stage = (Stage) plusHP.getScene().getWindow();
        stage.close();
    }
}
