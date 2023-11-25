package com.example.rpg.character;

import java.util.ArrayList;

public class LevelDB {
    private ArrayList<Level> levelArrayList = new ArrayList<>(); /*레벨 담는 리스트*/



    private static LevelDB instance = new LevelDB();
    /**
     * 레벨1~40의 경험치 기록
     */
    private  LevelDB() {
        int a = 1;
        int b = 10;
        while (true) {
            levelArrayList.add(new Level(a, b));
            a++;
            b += 3;
            if (a == 10) {
                break;
            }
        }
        while (true) {
            levelArrayList.add(new Level(a, b));
            a++;
            b += 4;
            if (a == 20) {
                break;
            }
        }
        while (true) {
            levelArrayList.add(new Level(a, b));
            a++;
            b += 5;
            if (a == 30) {
                break;
            }
        }
        while (true) {
            levelArrayList.add(new Level(a, b));
            a++;
            b += 10;
            if (a == 40) {
                break;
            }
        }
    }

    public static LevelDB getInstance() {
        return instance;
    }



    public ArrayList<Level> getLevelArrayList() {
        return levelArrayList;
    }



    @Override
    public String toString() {
        return "LevelDB{" +
                "levelArrayList=" + levelArrayList +
                '}';
    }


}