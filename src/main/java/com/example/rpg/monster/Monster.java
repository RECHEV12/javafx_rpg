package com.example.rpg.monster;

import com.example.rpg.GameUtillMethod;
import com.example.rpg.skill.Skill;

import java.util.ArrayList;

import static com.example.rpg.GameUtillMethod.myRound;

public class Monster {
    private int monsterGroup; /*몬스터 그룹*/
    private int monsterNum; /*몬스터 번호*/
    private String monsterName; /*몬스터 이름*/
    private int monsterLv; /*몬스터 레벨*/
    private String monsterType; /*몬스터 약점 타입*/
    private int monsterATK; /*몬스터 공격력*/

    public int getMonsterGroup() {
        return monsterGroup;
    }


    public void setMonsterGroup(int monsterGroup) {
        this.monsterGroup = monsterGroup;
    }

    public Monster(int monsterGroup, int monsterNum, String monsterName, int monsterLv, String monsterType, int monsterATK, int monsterDEF, int monsterHP) {
        this.monsterGroup = monsterGroup;
        this.monsterNum = monsterNum;
        this.monsterName = monsterName;
        this.monsterLv = monsterLv;
        this.monsterType = monsterType;
        this.monsterATK = monsterATK;
        this.monsterHP = monsterHP;
    }
    public Monster(Monster a){
        this.monsterGroup = a.getMonsterGroup();
        this.monsterNum = a.getMonsterNum();
        this.monsterName = a.getMonsterName();
        this.monsterLv = a.getMonsterLv();
        this.monsterType = a.getMonsterType();
        this.monsterATK = a.getMonsterATK();
        this.monsterHP = a.getMonsterHP();
    }

    @Override
    public String toString() {
        return "Monster{" + "monsterGroup=" + monsterGroup + ", monsterNum=" + monsterNum + ", monsterName='" + monsterName + '\'' + ", monsterLv=" + monsterLv + ", monsterType='" + monsterType + '\'' + ", monsterATK=" + monsterATK + ", monsterSkillList=" + monsterSkillList + ", monsterHP=" + monsterHP + '}';
    }

    public ArrayList<Skill> getMonsterSkillList() {
        return monsterSkillList;
    }

    public void setMonsterSkillList(ArrayList<Skill> monsterSkillList) {
        this.monsterSkillList = monsterSkillList;
    }

    public Monster(int monsterGroup, int monsterNum, String monsterName, int monsterLv, String monsterType, int monsterATK, ArrayList<Skill> monsterSkillList, int monsterHP) {
        this.monsterGroup = monsterGroup;
        this.monsterNum = monsterNum;
        this.monsterName = monsterName;
        this.monsterLv = monsterLv;
        this.monsterType = monsterType;
        this.monsterATK = monsterATK;
        this.monsterSkillList = monsterSkillList;
        this.monsterHP = monsterHP;
    }

    public ArrayList<Skill> monsterSkillList = new ArrayList<>();

    public Monster(int monsterGroup, int monsterNum, String monsterName, int monsterLv, String monsterType, int monsterATK, int monsterHP) {
        this.monsterGroup = monsterGroup;
        this.monsterNum = monsterNum;
        this.monsterName = monsterName;
        this.monsterLv = monsterLv;
        this.monsterType = monsterType;
        this.monsterATK = monsterATK;
        this.monsterHP = monsterHP;
    }

    public void battleMonsterData(Monster a, double b) {
        if (b == 1.0) {
            System.out.println("╔═════════════════════════╗");
            System.out.println("| " + a.getMonsterName() + " Lv." + a.getMonsterLv() + "\n" + "| "+"❤️ : " + a.getMonsterHP()+ "\n" + "몬스터 \uD83D\uDCAA 공격력 : " +a.getMonsterATK()
                    + "\n" + "약점 : " + a.getMonsterType());
            System.out.println("╚═════════════════════════╝");

        }
        if (b == 1.5) {
            System.out.println("╔═════════════════════════╗");
            System.out.println("| " + "🌟 " + a.getMonsterName() + " - Lv." + a.getMonsterLv() + "\n" +"| " + "❤\uFE0F : " + a.getMonsterHP()+ "\n"  + "몬스터 \uD83D\uDCAA 공격력 : " + a.getMonsterATK() + "\n" + "약점 : " + a.getMonsterType());
            System.out.println("╚═════════════════════════╝");
        }
    }


    public void realBattle() {

    }


    public int getExp(Monster a, double b) {
        int exp = (int) myRound(((a.getMonsterLv() * 3) + (a.getMonsterGroup() * b)), 1);
        return exp;
    }

    public int getMoney(Monster a, double b) {
        int money = (int) myRound((a.getMonsterLv() * (a.getMonsterGroup() * b)) * 50, 1);
        return money;
    }




    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    private int monsterHP;

    public Monster() {
    }

    public Monster(int monsterNum, String monsterName, int monsterLv, String monsterType, int monsterATK, int monsterDEF) {
        this.monsterNum = monsterNum;
        this.monsterName = monsterName;
        this.monsterLv = monsterLv;
        this.monsterType = monsterType;
        this.monsterATK = monsterATK;
    }

    public int getMonsterNum() {
        return monsterNum;
    }

    public void setMonsterNum(int monsterNum) {
        this.monsterNum = monsterNum;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterLv() {
        return monsterLv;
    }

    public void setMonsterLv(int monsterLv) {
        this.monsterLv = monsterLv;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public int getMonsterATK() {
        return monsterATK;
    }

    public void setMonsterATK(int monsterATK) {
        this.monsterATK = monsterATK;
    }


}

