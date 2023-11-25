package com.example.rpg.item;




public class Item {
    private String itemName; /*아이템 이름*/
    private String itemType; /*아이템 타입*/
    private int plusSTR; /*STR 부여*/
    private int plusDEX; /*DEX 부여*/
    private int plusINT; /*INT 부여*/
    private int plusLUK; /*LUK 부여*/
    private int plusNowHP; /*HP 부여*/
    private int plusMaxHP; /*HP 부여*/
    private int plusNowMP; /*MP 부여*/
    private int plusMaxMP; /*MP 부여*/
    private String itemDetail; /*상세 설명*/
    private boolean isNowEq; /*현재 장비중인가*/
    private String dropMob; /*누가 드랍하는지*/
    private int price; /*아이템 가격*/

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", plusSTR=" + plusSTR +
                ", plusDEX=" + plusDEX +
                ", plusINT=" + plusINT +
                ", plusLUK=" + plusLUK +
                ", plusNowHP=" + plusNowHP +
                ", plusMaxHP=" + plusMaxHP +
                ", plusNowMP=" + plusNowMP +
                ", plusMaxMP=" + plusMaxMP +
                ", itemDetail='" + itemDetail + '\'' +
                ", isNowEq=" + isNowEq +
                ", dropMob='" + dropMob + '\'' +
                ", price=" + price +
                '}';
    }

    public Item(String itemName, String itemType, int plusSTR, int plusDEX, int plusINT, int plusLUK, int plusNowHP, int plusMaxHP, int plusNowMP, int plusMaxMP, String itemDetail, boolean isNowEq, String dropMob, int price) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.plusSTR = plusSTR;
        this.plusDEX = plusDEX;
        this.plusINT = plusINT;
        this.plusLUK = plusLUK;
        this.plusNowHP = plusNowHP;
        this.plusMaxHP = plusMaxHP;
        this.plusNowMP = plusNowMP;
        this.plusMaxMP = plusMaxMP;
        this.itemDetail = itemDetail;
        this.isNowEq = isNowEq;
        this.dropMob = dropMob;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }



    public String getItemType() {
        return itemType;
    }


    public int getPlusSTR() {
        return plusSTR;
    }



    public int getPlusDEX() {
        return plusDEX;
    }



    public int getPlusINT() {
        return plusINT;
    }


    public int getPlusLUK() {
        return plusLUK;
    }


    public int getPlusNowHP() {
        return plusNowHP;
    }


    public int getPlusMaxHP() {
        return plusMaxHP;
    }


    public int getPlusNowMP() {
        return plusNowMP;
    }


    public int getPlusMaxMP() {
        return plusMaxMP;
    }


    public String getItemDetail() {
        return itemDetail;
    }


    public boolean isNowEq() {
        return isNowEq;
    }

    public void setNowEq(boolean nowEq) {
        isNowEq = nowEq;
    }

    public String getDropMob() {
        return dropMob;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
