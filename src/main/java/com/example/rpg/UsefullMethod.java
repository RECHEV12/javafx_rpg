package com.example.rpg;

import com.example.rpg.controller.*;
import com.example.rpg.item.Item;
import com.example.rpg.skill.Skill;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.example.rpg.GameUtillMethod.user;

/**
 * 화면 전환 메소드
 */
public class UsefullMethod {
    public static String startStage;


    public static void changeHome(Label nowLabel) {

        Stage stage = (Stage) nowLabel.getScene().getWindow();
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

    public static void goStatus(Label nowLabel) {
        Stage stage = (Stage) nowLabel.getScene().getWindow();
        startStage = stage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("status-view.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            StatusController statControl = fxmlLoader.getController();
            statControl.inputStatData();
            stage.setScene(scene);
            stage.setTitle("status");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void goSkillList(Label nowLabel) {
        Stage stage = (Stage) nowLabel.getScene().getWindow();
        startStage = stage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("skill-view.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            SkillController statControl = fxmlLoader.getController();
            statControl.showSkill();
            stage.setScene(scene);
            stage.setTitle("skill");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void goItemBox(Label nowLabel) {
        Stage stage = (Stage) nowLabel.getScene().getWindow();
        startStage = stage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("itemBox-view.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            ItemBoxController statControl = fxmlLoader.getController();
            statControl.showItem();
            stage.setScene(scene);
            stage.setTitle("itemBox");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void goField(Label nowLabel) {
        Stage stage = (Stage) nowLabel.getScene().getWindow();
        startStage = stage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("field-view.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("field");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void goReady(Label nowLabel) {
        Stage stage = (Stage) nowLabel.getScene().getWindow();
        startStage = stage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ready-view.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            ReadyController rc = fxmlLoader.getController();
            rc.setField();
            stage.setScene(scene);
            stage.setTitle("ready");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void goBattle(Label nowLabel) {
        Stage stage = (Stage) nowLabel.getScene().getWindow();
        startStage = stage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("battle-view.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            BattleController bc = fxmlLoader.getController();
            bc.showMonster();
            stage.setScene(scene);
            stage.setTitle("battle");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void goBack(Label nowLabel) {
        String fx = startStage + "-view.fxml";
        Stage stage = (Stage) nowLabel.getScene().getWindow();
        String change = stage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fx));


        switch (startStage) {
            case "skill":
                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    SkillController statControl = fxmlLoader.getController();
                    statControl.showSkill();
                    stage.setScene(scene);
                    stage.setTitle("skill");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "status":
                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    StatusController statControl = fxmlLoader.getController();
                    statControl.inputStatData();
                    stage.setScene(scene);
                    stage.setTitle("status");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "main":
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
                break;
            case "itemBox":
                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    ItemBoxController statControl = fxmlLoader.getController();
                    statControl.showItem();
                    stage.setScene(scene);
                    stage.setTitle("itemBox");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "field":

                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
                    stage.setTitle("field");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "ready":
                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    ReadyController rc = fxmlLoader.getController();
                    rc.setField();
                    stage.setScene(scene);
                    stage.setTitle("ready");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case  "battle":
                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    BattleController bc = fxmlLoader.getController();
                    bc.showMonster();
                    stage.setScene(scene);
                    stage.setTitle("battle");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }


        startStage = change;

    }


    public static void showAlertInfo(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }

    public static void showAlertErr(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }

    public static void showAlertWarn(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();

    }
}
