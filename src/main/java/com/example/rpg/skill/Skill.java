package com.example.rpg.skill;

public class Skill {
    private String skillName;
    private String skillType;
    private String skillInfo;
    private int learnLevel;
    private String classType;
    private int useMp;
    private int perStr;
    private int perInt;
    private int perDex;

    public Skill() {
    }

    public Skill(String skillName, String skillType, String skillInfo, int learnLevel, String classType, int useMp, int perStr, int perInt, int perDex) {
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillInfo = skillInfo;
        this.learnLevel = learnLevel;
        this.classType = classType;
        this.useMp = useMp;
        this.perStr = perStr;
        this.perInt = perInt;
        this.perDex = perDex;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillInfo() {
        return skillInfo;
    }

    public void setSkillInfo(String skillInfo) {
        this.skillInfo = skillInfo;
    }

    public int getLearnLevel() {
        return learnLevel;
    }

    public void setLearnLevel(int learnLevel) {
        this.learnLevel = learnLevel;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getUseMp() {
        return useMp;
    }

    public void setUseMp(int useMp) {
        this.useMp = useMp;
    }

    public int getPerStr() {
        return perStr;
    }

    public void setPerStr(int perStr) {
        this.perStr = perStr;
    }

    public int getPerInt() {
        return perInt;
    }

    public void setPerInt(int perInt) {
        this.perInt = perInt;
    }

    public int getPerDex() {
        return perDex;
    }

    public void setPerDex(int perDex) {
        this.perDex = perDex;
    }
}
