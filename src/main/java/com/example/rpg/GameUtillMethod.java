package com.example.rpg;


import com.example.rpg.character.Class;
import com.example.rpg.character.Level;
import com.example.rpg.item.Item;
import com.example.rpg.item.ItemDB;
import com.example.rpg.monster.Monster;
import com.example.rpg.skill.Skill;
import com.example.rpg.skill.SkillDB;
import com.example.rpg.character.LevelDB;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class GameUtillMethod {
    public static String selectedClass = "";
    public static Class user = new Class();
    public static ArrayList<Monster> nowMonsterList = new ArrayList<>();
    public static String nowFieldName = "";
    public static Monster nowMob = new Monster();
    public static int isRare = 0;


    public static int makeRandom(int a, int b) {
        return (int) ((Math.random() * (b - a + 1)) + a);
    }

    public static double myRound(double num, int n) {
        int bai = 1;
        for (int i = 0; i < n; i++) {
            bai = 10 * bai;
        }
        return (double) Math.round(num * bai) / bai;
    }

    public static double random5perRare() {
        double a = 0;
        int ab = makeRandom(1, 100);
        if (ab >= 1 && ab <= 5) {
            a = 1.5;
        } else {
            a = 1;
        }
        return a;
    }

    public static void setMonster(Monster a, Class user) {
        // 레벨 설정
        if (a.getMonsterGroup() == 1) {
            if (user.getLv() < 5) {
                a.setMonsterLv(makeRandom(1, 5));
            } else {
                a.setMonsterLv(makeRandom(1, 9));
            }

        } else if (a.getMonsterGroup() == 2) {
            if (user.getLv() < 15) {
                a.setMonsterLv(makeRandom(10, 15));
            } else {
                a.setMonsterLv(makeRandom(10, 19));
            }
        } else if (a.getMonsterGroup() == 3) {
            if (user.getLv() < 25) {
                a.setMonsterLv(makeRandom(20, 25));
            } else {
                a.setMonsterLv(makeRandom(20, 29));
            }
        } else if (a.getMonsterGroup() == 4) {
            if (user.getLv() < 35) {
                a.setMonsterLv(makeRandom(30, 35));
            } else {
                a.setMonsterLv(makeRandom(30, 39));
            }
        }


        a.setMonsterHP(a.getMonsterHP() + (a.getMonsterLv() * 2));
        a.setMonsterATK(a.getMonsterATK() + a.getMonsterLv());


    }

    public static Skill monsterChoiceSkill(ArrayList<Skill> list) {
        int num = makeRandom(0, list.size() - 1);

        Skill skill = list.get(num);

        return skill;

    }

    public static int getMonsterDamage(Skill skr, Monster mob) {
        double num = (skr.getPerStr() / (double) 100);
        return (int) myRound((mob.getMonsterATK()) * num, 1);
    }

    public static int defDamage(Class user, Skill skr) {
        double num = (skr.getPerDex() / (double) 100);
        return (int) myRound((num * user.getStatDEX()), 1);
    }

    public static int getExp(Monster a, int b) {
        double rare;
        if (b == 0) {
            rare = 1.0;
        } else {
            rare = 1.5;
        }
        int exp = (int) myRound(((a.getMonsterLv() * 3) + (a.getMonsterGroup() * rare)), 1);
        return exp;
    }
    public static int getMoney(Monster a, int b) {
        double rare;
        if (b == 0) {
            rare = 1.0;
        } else {
            rare = 1.5;
        }
        int money = (int) myRound((a.getMonsterLv() * (a.getMonsterGroup() * rare)) * 50, 1);
        return money;
    }
    public static Item dropItem(Monster a) {
        //todo 아이템 레어도에 따른 드랍률 조정
        ArrayList<Item> temp = new ArrayList<>();

        ItemDB itemDB = new ItemDB();

        Item tempItem = new Item();

        for (Item it : itemDB.getItemList()) {
            if (it.getDropMob().equals(a.getMonsterName())) {
                temp.add(it);
            }
        }
        System.out.println(temp);

        int b = random5perInt();
        if (b == 1) {
            int randomNum = makeRandom(0, temp.size() - 1);
            tempItem = temp.get(randomNum);
        }
        return tempItem;
    }
    public static int random5perInt() {
        int a = makeRandom(1, 100);
        int b = 0;
        if (a >=0 && a <=5){
            b= 1;
        }
        return b;
    }
    public static void levelUP(Class user) {


                if (user.getPlayerClass().equals("전사")) {
                    user.setStatSTR(user.getStatSTR() + 3);
                    user.setStatDEX(user.getStatDEX() + 2);
                    user.setStatINT(user.getStatINT() + 1);
                    user.setStatNowHP(user.getStatNowHP() + 5);
                    user.setStatMaxHP(user.getStatMaxHP() + 12);
                    user.setStatNowMP(user.getStatNowMP() + 8);
                    user.setStatMaxMP(user.getStatMaxMP() + 8);
                    user.setStatLUK(user.getStatLUK() + 1);
                    user.setExtraStat(user.getExtraStat() + 4);


                }
                if (user.getPlayerClass().equals("마법사")) {
                    user.setStatSTR(user.getStatSTR() + 1);
                    user.setStatDEX(user.getStatDEX() + 1);
                    user.setStatINT(user.getStatINT() + 4);
                    user.setStatNowHP(user.getStatNowHP() + 5);
                    user.setStatMaxHP(user.getStatMaxHP() + 10);
                    user.setStatNowMP(user.getStatNowMP() + 12);
                    user.setStatMaxMP(user.getStatMaxMP() + 12);
                    user.setStatLUK(user.getStatLUK() + 1);
                    user.setExtraStat(user.getExtraStat() + 4);

                }


    }

    public static Label userAddSkill(Class user) {
        Label skillLabel = new Label();
        SkillDB skillDB = SkillDB.getInstance();

        if (user.getPlayerClass().contains("전사")) {
            for (Skill skill : skillDB.getSkillList()) {
                if (user.getLv() == skill.getLearnLevel() && skill.getClassType().equals("전사")) {
                    user.getPlayerSkillList().add(skill);
                    skillLabel.setText(user.getPlayerName() + "은(는) " + skill.getSkillName() + "을(를) 습득했다!");
                    break;
                }


            }

        } else if (user.getPlayerClass().contains("마법사")) {
            for (Skill skill : skillDB.getSkillList()) {
                if (user.getLv() == skill.getLearnLevel() && skill.getClassType().equals("마법사")) {
                    user.getPlayerSkillList().add(skill);
                    skillLabel.setText(user.getPlayerName() + "은(는) " + skill.getSkillName() + "을(를) 습득했다!");
                    break;
                }


            }
        }
        return skillLabel;

    }
    public static int getNextExp(int userLv) {
        int nextLevel = 0;
        LevelDB levelDB = LevelDB.getInstance();
        for (Level lv : levelDB.getLevelArrayList()) {
            if (userLv == lv.getLevelNow()) {
                nextLevel = lv.getLevelExp();
            }
        }
        return nextLevel;
    }
    public static double criticalReturn(Class user) {
        double crtical;
        if (user.getStatLUK() >= 100) {
            crtical = 1.5;
        } else {
            double retouch = ((double) user.getStatDEX() / 5);
            int randNum = makeRandom(1, 100);
            int num = (int) myRound((5 + retouch), 1);
            if (randNum >= 1 && randNum <= num) {
                crtical = 1.5;
            } else {
                crtical = 1;
            }
        }

        return crtical;

    }

    public static int getUserDamage(Class user, Skill skr, Monster mob) {
        int strDamage = (int)myRound(user.getStatSTR() * (skr.getPerStr() /(double) 100),1);
        int intDamage = (int)myRound(user.getStatINT() * (skr.getPerInt()/ (double)100),1);

        double typeCritical = 1;
        if ((skr.getSkillType().equals("참격") && mob.getMonsterType().equals("참격약점")) ||
                (skr.getSkillType().equals("마법") && mob.getMonsterType().equals("마법약점"))) {
            typeCritical = 1.3;
        }



        double totalDamage = ((strDamage + intDamage) * (typeCritical)) * (criticalReturn(user));

        return (int) myRound(totalDamage, 1);

    }


}