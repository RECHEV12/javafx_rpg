package com.example.rpg;


import com.example.rpg.character.Class;
import com.example.rpg.monster.Monster;
import com.example.rpg.skill.Skill;

import java.util.ArrayList;

public class GameUtillMethod {
    public static String selectedClass = "";
    public static Class user = new Class();
    public static ArrayList<Monster> nowMonsterList = new ArrayList<>();
    public static String nowFieldName = "";
    public static  Monster nowMob = new Monster();
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
            if (user.getLv() < 5){
                a.setMonsterLv(makeRandom(1, 5));
            }else {
                a.setMonsterLv(makeRandom(1, 9));
            }

        } else if (a.getMonsterGroup() == 2) {
            if (user.getLv() < 15) {
                a.setMonsterLv(makeRandom(10, 15));
            }else {
                a.setMonsterLv(makeRandom(10, 19));
            }
        } else if (a.getMonsterGroup() == 3) {
            if (user.getLv() < 25) {
                a.setMonsterLv(makeRandom(20, 25));
            }else {
                a.setMonsterLv(makeRandom(20, 29));
            }
        } else if (a.getMonsterGroup() == 4) {
            if (user.getLv() < 35) {
                a.setMonsterLv(makeRandom(30, 35));
            }else {
                a.setMonsterLv(makeRandom(30, 39));
            }
        }


        a.setMonsterHP(a.getMonsterHP() + (a.getMonsterLv() * 2));
        a.setMonsterATK(a.getMonsterATK() +a.getMonsterLv());


    }

    public static Skill monsterChoiceSkill(ArrayList<Skill> list) {
        int num = makeRandom(0, list.size() - 1);

        Skill skill = list.get(num);

        return skill;

    }

    public static int getMonsterDamage(Skill skr, Monster mob) {
        double num =(skr.getPerStr() / (double)100);
        return(int) myRound((mob.getMonsterATK()) * num,1);
    }
    public static int defDamage(Class user, Skill skr) {
        double num =(skr.getPerDex() / (double)100);
        return    (int)myRound((num * user.getStatDEX()),1);
    }
}