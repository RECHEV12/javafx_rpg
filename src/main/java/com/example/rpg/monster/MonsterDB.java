package com.example.rpg.monster;



import java.util.ArrayList;

public class MonsterDB {
    private ArrayList<Monster> monsterList = new ArrayList<>();

    private MonsterDB() {
        monsterList.add(new Monster(1, 1, "고블린", 0, "참격약점", 10, 5));
        monsterList.add(new Monster(1, monsterList.size() + 1, "슬라임", 0, "참격약점", 10, 5));

        monsterList.add(new Monster(2, monsterList.size() + 1, "홉고블린", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(2, monsterList.size() + 1, "산성슬라임", 0, "참격약점", 5, 10));

        monsterList.add(new Monster(3, monsterList.size() + 1, "흑랑", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(3, monsterList.size() + 1, "세이렌", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(3, monsterList.size() + 1, "골렘", 0, "참격약점", 5, 10));

        monsterList.add(new Monster(4, monsterList.size() + 1, "오우거", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(4, monsterList.size() + 1, "마인", 0, "참격약점", 5, 10));
        monsterList.add(new Monster(4, monsterList.size() + 1, "타천사", 0, "참격약점", 5, 10));

        monsterList.add(new Monster(5, monsterList.size() + 1, "대왕슬라임", 10, "참격약점", 5, 10));
        monsterList.add(new Monster(6, monsterList.size() + 1, "킹고블린", 20, "참격약점", 5, 10));
        monsterList.add(new Monster(7, monsterList.size() + 1, "거대 골렘", 30, "참격약점", 5, 10));
        monsterList.add(new Monster(8, monsterList.size() + 1, "드래곤", 40, "참격약점", 5, 10));

    }

    public static MonsterDB instance = new MonsterDB();

    public static MonsterDB getInstance() {
        return instance;
    }






    @Override
    public String toString() {
        return "MonsterDB{" +
                "monsterList=" + monsterList +
                '}';
    }

    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }


}
