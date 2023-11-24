package com.example.rpg.controller;

import com.example.rpg.HelloApplication;
import com.example.rpg.item.Item;
import com.example.rpg.item.ItemDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.example.rpg.GameUtillMethod.user;
import static com.example.rpg.UsefullMethod.changeHome;
import static com.example.rpg.UsefullMethod.goBack;
import static com.example.rpg.controller.UseItemController.updateEquips;

public class ItemBoxController {

    @FXML
    public Label label;
    @FXML
    private VBox itemVBox;
    @FXML
    private VBox weaponVBox;
    @FXML
    private VBox equipVBox;

    ArrayList<Item> itemList = user.getItemsList();

    @FXML
    public void showItem() {
        System.out.println(user.getStatSTR());
        System.out.println(user.getWeapon().getItemName());
        Insets inset = new Insets(10);
        BorderStroke stroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 2, 2, 2));
        BorderStroke strokeA = new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 0, 2, 0));
        BorderStroke strokeB = new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(0, 2, 0, 2));
        BorderStroke test1 = new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, null, new BorderWidths(2, 2, 2, 2));
        Border border = new Border(stroke);
        Border borderA = new Border(strokeA);
        Border borderB = new Border(strokeB);
        Border test = new Border(test1);

        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            int index = i;
            VBox nowBox;
            if (item.getItemType().equals("무기")) {
                nowBox = weaponVBox;

            } else if (item.getItemType().equals("방어구")) {
                nowBox = equipVBox;
            } else {
                nowBox = itemVBox;
                if (item.isNowEq()){
                    itemList.remove(item);
                    i--;
                    continue;
                }
            }


            VBox main = new VBox();
            main.setBorder(border);
            main.setPadding(inset);

            HBox upHBox = new HBox();
            upHBox.setBorder(borderA);
            upHBox.setPadding(inset);
            upHBox.setPrefWidth(nowBox.getPrefWidth());


            HBox downHBox = new HBox();
            downHBox.setBorder(borderA);
            downHBox.setPadding(inset);


            VBox firstBox = new VBox();
            firstBox.setPrefWidth(upHBox.getPrefWidth() / 4);
            firstBox.setBorder(borderB);
            firstBox.setPadding(inset);
            firstBox.setSpacing(15);

            VBox secondBox = new VBox();
            secondBox.setPrefWidth(upHBox.getPrefWidth() / 4 - 20);
            secondBox.setBorder(borderB);
            secondBox.setPadding(inset);

            VBox thirdBox = new VBox();
            thirdBox.setPrefWidth(upHBox.getPrefWidth() / 4 + 20);
            thirdBox.setBorder(borderB);
            thirdBox.setPadding(inset);

            VBox fourthBox = new VBox();
            fourthBox.setPrefWidth(upHBox.getPrefWidth() / 4);
            fourthBox.setBorder(borderB);
            fourthBox.setPadding(inset);
            fourthBox.setSpacing(15);

            Label itemName = new Label();
            itemName.setText("이름 : " + item.getItemName());
            itemName.setPrefWidth(firstBox.getPrefWidth());
            itemName.setAlignment(Pos.CENTER);

            Label itemType = new Label();
            itemType.setText(item.getItemType());
            itemType.setPrefWidth(firstBox.getPrefWidth());
            itemType.setAlignment(Pos.CENTER);

            Label itemDrop = new Label();
            itemDrop.setText(item.getDropMob());
            itemDrop.setPrefWidth(firstBox.getPrefWidth());
            itemDrop.setAlignment(Pos.CENTER);

            firstBox.getChildren().addAll(itemName, itemType, itemDrop);


            HBox strDex = new HBox();
            strDex.setPadding(inset);
            strDex.setPrefWidth(secondBox.getPrefWidth());
            strDex.setBorder(borderA);

            HBox intLuk = new HBox();
            intLuk.setPadding(inset);
            intLuk.setPrefWidth(secondBox.getPrefWidth());
            intLuk.setBorder(borderA);

            Label itemSTR = new Label();
            itemSTR.setText("STR + " + item.getPlusSTR());
            itemSTR.setPrefWidth(strDex.getPrefWidth() / 2);
            itemSTR.setAlignment(Pos.CENTER);

            Label itemDEX = new Label();
            itemDEX.setText("DEX + " + item.getPlusDEX());
            itemDEX.setPrefWidth(strDex.getPrefWidth() / 2);
            itemDEX.setAlignment(Pos.CENTER);

            Label itemINT = new Label();
            itemINT.setText("INT + " + item.getPlusINT());
            itemINT.setPrefWidth(intLuk.getPrefWidth() / 2);
            itemINT.setAlignment(Pos.CENTER);

            Label itemLUK = new Label();
            itemLUK.setText("LUK + " + item.getPlusLUK());
            itemLUK.setPrefWidth(intLuk.getPrefWidth() / 2);
            itemLUK.setAlignment(Pos.CENTER);

            strDex.getChildren().addAll(itemSTR, itemDEX);
            intLuk.getChildren().addAll(itemINT, itemLUK);

            secondBox.getChildren().addAll(strDex, intLuk);


            HBox setHP = new HBox();
            setHP.setPadding(inset);
            setHP.setPrefWidth(thirdBox.getPrefWidth());
            setHP.setBorder(borderA);


            HBox setMP = new HBox();
            setMP.setPadding(inset);
            setMP.setPrefWidth(thirdBox.getPrefWidth());
            setMP.setBorder(borderA);

            Label nowHP = new Label();
            nowHP.setText("현재 체력 + " + item.getPlusNowHP());
            nowHP.setPrefWidth(setHP.getPrefWidth() / 2);
            nowHP.setAlignment(Pos.CENTER);

            Label maxHP = new Label();
            maxHP.setText("최대 체력 + " + item.getPlusMaxHP());
            maxHP.setPrefWidth(setHP.getPrefWidth() / 2);
            maxHP.setAlignment(Pos.CENTER);

            Label nowMP = new Label();
            nowMP.setText("현재 마나 + " + item.getPlusNowMP());
            nowMP.setPrefWidth(setMP.getPrefWidth() / 2);
            nowMP.setAlignment(Pos.CENTER);

            Label maxMP = new Label();
            maxMP.setText("최대 마나 + " + item.getPlusMaxMP());
            maxMP.setPrefWidth(setMP.getPrefWidth() / 2);
            maxMP.setAlignment(Pos.CENTER);

            setHP.getChildren().addAll(nowHP, maxHP);
            setMP.getChildren().addAll(nowMP, maxMP);

            thirdBox.getChildren().addAll(setHP, setMP);

            Button useBtn = new Button();
            useBtn.setText("사용/장착");
            useBtn.setPrefWidth(fourthBox.getPrefWidth());
            useBtn.setAlignment(Pos.CENTER);
            useBtn.setOnAction(event -> showItemPopup(item, index, label));

            String temp;
            if (item.isNowEq()) {
                temp = "착용중";
            } else {
                temp = "미착용중";
            }

            Label nowEQ = new Label();
            nowEQ.setText(temp);
            nowEQ.setPrefWidth(fourthBox.getPrefWidth());
            nowEQ.setAlignment(Pos.CENTER);

            Label price = new Label();
            price.setText("판매가격 : " + item.getPrice());
            price.setPrefWidth(fourthBox.getPrefWidth());
            price.setAlignment(Pos.CENTER);

            fourthBox.getChildren().addAll(useBtn, nowEQ, price);


            upHBox.getChildren().addAll(firstBox, secondBox, thirdBox, fourthBox);

            Label itemDesc = new Label();
            itemDesc.setText(item.getItemDetail());
            downHBox.getChildren().add(itemDesc);


            main.getChildren().addAll(upHBox, downHBox);
            nowBox.getChildren().add(main);

        }


    }

    public void showItemPopup(Item item, int index, Label label) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("useItem-view.fxml"));
            Parent root = fxmlLoader.load();
            UseItemController uic = fxmlLoader.getController();
            uic.showUpStat(item);
            uic.idx = index;
            uic.label = label;
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("useItem");

            Scene scene = new Scene(root);
            popupStage.setScene(scene);
            popupStage.showAndWait();
            clearItemBox();
            showItem();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void clearItemBox() {

        weaponVBox.getChildren().clear();
        equipVBox.getChildren().clear();
        itemVBox.getChildren().clear();


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
