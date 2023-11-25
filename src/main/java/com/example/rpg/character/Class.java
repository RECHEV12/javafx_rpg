package com.example.rpg.character;

import com.example.rpg.item.Item;
import com.example.rpg.skill.Skill;

import java.util.ArrayList;


public class Class {
    private String playerClass; /*캐릭터 직업*/
    private String playerName; /*플레이어 이름*/
    private int lv; /*플레이어 레벨*/
    private int exp; /*경험치*/
    private int nextExp; /*다음 레벨업을 위한 경험치*/
    private int statSTR; /*캐릭터 힘*/
    private int statDEX; /*캐릭터 명중률/회피율*/
    private int statINT; /*캐릭터 지능*/
    private int statLUK; /*캐릭터 운*/
    private int statNowHP; /* 캐릭터 체력*/
    private int statMaxHP; /* 캐릭터 체력*/
    private int statNowMP; /*캐릭터 마나*/
    private int statMaxMP; /*캐릭터 마나*/
    private int extraStat; /*캐릭터 스탯 분배 여분 포인트*/
    private int money; /*소지금*/
    private Item weapon; /*캐릭터 무기*/
    private Item equip; /*캐릭터 방어구*/
    public ArrayList<Skill> playerSkillList = new ArrayList<>(); /*캐릭터 스킬 리스트*/
    private ArrayList<Item> itemsList = new ArrayList<>(); /*캐릭터 아이템 리스트*/

    public Class() {
    }

    public Class(String playerClass, String playerName, int lv, int exp, int nextExp, int statSTR, int statDEX, int statINT, int statLUK, int statNowHP, int statMaxHP, int statNowMP, int statMaxMP, int extraStat, int money) {
        this.playerClass = playerClass;
        this.playerName = playerName;
        this.lv = lv;
        this.exp = exp;
        this.nextExp = nextExp;
        this.statSTR = statSTR;
        this.statDEX = statDEX;
        this.statINT = statINT;
        this.statLUK = statLUK;
        this.statNowHP = statNowHP;
        this.statMaxHP = statMaxHP;
        this.statNowMP = statNowMP;
        this.statMaxMP = statMaxMP;
        this.extraStat = extraStat;
        this.money = money;
        this.weapon = new Item();
        this.equip =  new Item();
        this.playerSkillList = new ArrayList<>();
        this.itemsList = new ArrayList<>();
    }

    public static Class warrior = new Class("전사", "", 1, 0, 10, 12, 10, 7,
            5, 17, 17, 9, 9, 0, 1000);
    public static  Class magician = new Class("마법사", "", 1, 0, 10, 7, 10, 12,
            5, 14, 14, 12, 12, 0, 1000);

    public String getPlayerClass() {
        return playerClass;
    }



    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNextExp() {
        return nextExp;
    }

    public void setNextExp(int nextExp) {
        this.nextExp = nextExp;
    }

    public int getStatSTR() {
        return statSTR;
    }

    public void setStatSTR(int statSTR) {
        this.statSTR = statSTR;
    }

    public int getStatDEX() {
        return statDEX;
    }

    public void setStatDEX(int statDEX) {
        this.statDEX = statDEX;
    }

    public int getStatINT() {
        return statINT;
    }

    public void setStatINT(int statINT) {
        this.statINT = statINT;
    }

    public int getStatLUK() {
        return statLUK;
    }

    public void setStatLUK(int statLUK) {
        this.statLUK = statLUK;
    }

    public int getStatNowHP() {
        return statNowHP;
    }

    public void setStatNowHP(int statNowHP) {
        this.statNowHP = statNowHP;
    }

    public int getStatMaxHP() {
        return statMaxHP;
    }

    public void setStatMaxHP(int statMaxHP) {
        this.statMaxHP = statMaxHP;
    }

    public int getStatNowMP() {
        return statNowMP;
    }

    public void setStatNowMP(int statNowMP) {
        this.statNowMP = statNowMP;
    }

    public int getStatMaxMP() {
        return statMaxMP;
    }

    public void setStatMaxMP(int statMaxMP) {
        this.statMaxMP = statMaxMP;
    }

    public int getExtraStat() {
        return extraStat;
    }

    public void setExtraStat(int extraStat) {
        this.extraStat = extraStat;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Item getEquip() {
        return equip;
    }

    public void setEquip(Item equip) {
        this.equip = equip;
    }

    public ArrayList<Skill> getPlayerSkillList() {
        return playerSkillList;
    }


    public ArrayList<Item> getItemsList() {
        return itemsList;
    }


}