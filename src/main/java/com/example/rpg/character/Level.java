package com.example.rpg.character;

public class Level {
   private int levelNow; /*현재 레벨*/
    private int levelExp; /*레벨 다음 레벨업에 필요한 경험치*/

    public Level(int levelNow, int levelExp) {
        this.levelNow = levelNow;
        this.levelExp = levelExp;
    }

    @Override
    public String toString() {
        return "현재 레벨 : " + levelNow + "\n" +
                "다음 레벨까지 필요한 경험치" + levelExp + "\n" +
                "========================\n ";
    }

    public int getLevelNow() {
        return levelNow;
    }


    public int getLevelExp() {
        return levelExp;
    }


}

