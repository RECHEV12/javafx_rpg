package com.example.rpg.item;

import java.util.ArrayList;

public class ItemDB {


    public ArrayList<Item> itemList = new ArrayList<>(); /*아이템 목록*/


    public ItemDB() {
        itemList.add(new Item("몽둥이", "무기", 3, 3, 3, 0, 0, 0, 0, 0, "고블린이 들고다니던 몽둥이. 고블린이 드랍한다.", false, "고블린", 1000));
        itemList.add(new Item("고블린 도끼", "무기", 10, 5, 10, 0, 3, 3, 0, 0, "홉 고블린의 도끼", false, "홉고블린", 3000));
        itemList.add(new Item("왕의 증표", "무기", 20, 15, 20, 0, 3, 3, 0, 0, "킹 고블린의 왕관", false, "킹고블린", 4000));
        itemList.add(new Item("클레이모어", "무기", 30, 25, 30, 0, 5, 5, 5, 5, "오우거의 전사라는 증표가 달린 검", false, "오우거", 6000));
        itemList.add(new Item("드래곤 소드", "무기", 40, 35, 40, 20, 40, 40, 40, 40, "드래곤의 뼈로 만든 검", false, "드래곤", 10000));


        itemList.add(new Item("끈적한 옷", "방어구", 2, 1, 2, 0, 3, 3, 3, 3, "슬라임의 점성으로 만든 끈적한 옷, 슬라임이 드랍한다.", false, "슬라임", 1000));
        itemList.add(new Item("큰 끈적한 옷", "방어구", 7, 3, 7, 0, 10, 10, 5, 5, "대왕 슬라임의 점성으로 만든 끈적한 옷. 대왕슬라임이 드랍한다.", false, "대왕슬라임", 2000));
        itemList.add(new Item("산성갑옷", "방어구", 10, 7, 10, 0, 14, 14, 10, 10, "산성슬라임의 단단한 옷", false, "산성슬라임", 3000));
        itemList.add(new Item("흑랑복", "방어구", 14, 9, 14, 0, 18, 18, 14, 14, "흑랑의 가죽으로 만든 튼튼한 옷", false, "흑랑", 5000));
        itemList.add(new Item("심안의 머리장식", "방어구", 18, 10, 18, 0, 20, 20, 16, 16, "세이렌의 깃털로 만든 머리장식", false, "세이렌", 5000));
        itemList.add(new Item("돌갑옷", "방어구", 22, 3, 22, 0, 23, 23, 18, 18, "골렘의 돌을 깎아 만든 갑옷", false, "골렘", 5000));
        itemList.add(new Item("큰 돌갑옷", "방어구", 24, 3, 24, 0, 26, 26, 20, 20, "거대 골렘의 돌을 깎아 만든 갑옷", false, "거대 골렘", 5500));
        itemList.add(new Item("빛나는 혈석", "방어구", 22, 3, 30, 0, 24, 24, 30, 30, "마인의 보석", false, "마인", 6000));
        itemList.add(new Item("천사의 날개옷", "방어구", 30, 3, 22, 0, 30, 30, 25, 25, "타천사의 날개옷", false, "타천사", 6000));
        itemList.add(new Item("용의 갑주", "방어구", 35, 35, 35, 35, 40, 40, 40, 40, "드래곤 가죽으로 만든 튼튼한 옷", false, "드래곤", 10000));


        itemList.add(new Item("사과", "포션", 0, 0, 0, 0, 10, 0, 5, 0, "맛있어보이는 사과이다.", false, "슬라임, 고블린, 대왕슬라임, 홉고블린, 산성슬라임, 킹고블린", 200));
        itemList.add(new Item("맛있는 사과", "포션", 0, 0, 0, 0, 20, 0, 10, 0, "더 더  맛있어보이는 사과이다.", false, "흑랑, 세이렌, 거대 골렘", 500));
        itemList.add(new Item("골드 애플", "포션", 0, 0, 0, 0, 30, 0, 20, 0, "더 더  맛있어보이는 사과이다.", false, "오우거, 타천사, 마인", 1000));
        itemList.add(new Item("선악과", "포션", 0, 0, 0, 0, 40, 0, 30, 0, "더 더  맛있어보이는 사과이다.", false, "드래곤", 2000));
        itemList.add(new Item("딸기", "포션", 0, 0, 0, 0, 5, 0, 10, 0, "맛있어보이는 딸기이다.", false, "슬라임, 고블린, 대왕슬라임, 홉고블린, 산성슬라임, 킹고블린", 200));
        itemList.add(new Item("맛있는 딸기", "포션", 0, 0, 0, 0, 10, 0, 20, 0, "더 맛있어보이는 딸기이다.", false, "흑랑, 세이렌, 거대 골렘", 500));
        itemList.add(new Item("골드 스트로베리", "포션", 0, 0, 0, 0, 20, 0, 30, 0, "더 더 맛있어보이는 딸기이다.", false, "오우거, 타천사, 마인", 1000));
        itemList.add(new Item("마나 엘릭서", "포션", 0, 0, 0, 0, 30, 0, 40, 0, "마나를 대량으로 회복시켜주는 포션이다", false, "드래곤", 2000));


    }






    @Override
    public String toString() {
        return "ItemDB{" +
                "itemList=" + itemList +
                '}';
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }


}
