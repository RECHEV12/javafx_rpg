package com.example.rpg.monster;

import com.example.rpg.skill.Skill;

import java.util.ArrayList;



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






    @Override
    public String toString() {
        return "Monster{" + "monsterGroup=" + monsterGroup + ", monsterNum=" + monsterNum + ", monsterName='" + monsterName + '\'' + ", monsterLv=" + monsterLv + ", monsterType='" + monsterType + '\'' + ", monsterATK=" + monsterATK + ", monsterSkillList=" + monsterSkillList + ", monsterHP=" + monsterHP + '}';
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





    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    private int monsterHP;

    public Monster() {
    }


    public String getMonsterName() {
        return monsterName;
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


    public int getMonsterATK() {
        return monsterATK;
    }

    public void setMonsterATK(int monsterATK) {
        this.monsterATK = monsterATK;
    }


}

