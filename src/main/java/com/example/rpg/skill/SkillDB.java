package com.example.rpg.skill;

import java.util.ArrayList;

public class SkillDB {
    public ArrayList<Skill> playerSkillList = new ArrayList<>();


// 대미지 계산식 (str * 계수) + (int * 계수) + (타입 * 몹타입) 후, mp소모하고 , 상태이상 있을시 독립시

    // todo 스킬 대미지 설정 제대로 넣기
    private SkillDB() {
        // 검사공용
        playerSkillList.add(new Skill("찌르기", "⚔\uFE0F참격", "대검으로 찌릅니다.", 1, "전사", 0, 40, 30, 0));
        playerSkillList.add(new Skill("\uD83D\uDEE1\uFE0F 막기", "방어", "검으로 막습니다. DEX가 높을 시, 더 많은 수치의 대미지를 방어합니다.", 1, "전사", 0, 20, 0, 80));
        playerSkillList.add(new Skill("⚔\uFE0F 크게 휘두르기", "참격", "대검으로 크게 휘두릅니다. ", 5, "전사", 4, 50, 30, 0));
        playerSkillList.add(new Skill("⚔\uFE0F 십자베기", "참격", "대검을 십자로 휘둘러 참격을 입힙니다.", 10, "전사", 6, 70, 40, 0));
        playerSkillList.add(new Skill("⚔\uFE0F 홀리 슬래시", "참격", "빛을 검에 담아 베어가릅니다.", 15, "전사", 8, 80, 40, 0));
        playerSkillList.add(new Skill("\uD83D\uDD2E  홀리 레이", "마법", "빛으로 된 레이저를 발사합니다.", 20, "전사", 10, 50, 100, 0));
        playerSkillList.add(new Skill("⚔\uFE0F2회전 베기", "참격", "검을 두 번 연속으로 휘두릅니다. ", 25, "", 12, 120, 50, 0));
        playerSkillList.add(new Skill("⚔\uFE0F별모양 베기", "참격", "별 모양으로 베어가릅니다. ", 30, "전사", 14, 140, 50, 0));
        playerSkillList.add(new Skill("\uD83E\uDE85천사의 망치", "참격", "다음 공격이 확정적으로 2배의 대미지를 줍니다.", 35, "전사", 16, 160, 50, 0));
        playerSkillList.add(new Skill("\uD83C\uDF87스타라이트 스트림", "참격", "별무리와 같은 빛을 내며 검을 휘두릅니다.  ", 40, "전사", 20, 180, 50, 10));

//        playerSkillList.add(new Skill("\uD83D\uDC89 HP힐", "버프", "체력을 회복합니다. \n STR 20% | DEX 40%", 18,"전사",20, 20, 0, 40));
        //        playerSkillList.add(new Skill("\uD83E\uDE85오러 두르기", "버프", "몸에 오러를 둘러 공격력을 높입니다. \n STR * 2", 30,"전사",1, 0, 0, 0));
        //마법사공용
        playerSkillList.add(new Skill("\uD83D\uDD2E 매직 미사일", "마법", "마법으로 된 미사일을 발사합니다.", 1, "마법사", 0, 30, 40, 0));
        playerSkillList.add(new Skill("\uD83D\uDEE1\uFE0F 마나 실드", "방어", "마나를 몸 주위에 펼쳐 적의 공격을 방어합니다. ", 1, "마법사", 0, 20, 0, 0));
        playerSkillList.add(new Skill("\uD83D\uDD2E 차지 미사일", "마법", "미사일을 응축시켜 빠르게 쏘아냅니다.", 5, "마법사", 4, 30, 50, 0));
        playerSkillList.add(new Skill("\uD83D\uDD2E 마나 봄", "마법", "마력을 한 곳에 응집시켜 폭발시킵니다. ", 10, "마법사", 6, 40, 70, 0));
        playerSkillList.add(new Skill("\uD83D\uDD2E 파이어 볼", "마법", "마력에 불의 힘을 담아 공의 형태로 쏘아냅니다. ", 15, "마법사", 8, 40, 80, 0));
        playerSkillList.add(new Skill("⚔\uFE0F 블레이즈 소드", "참격", "불로 된 검을 만들어 참격을 입힙니다. ", 20, "마법사", 10, 100, 50, 0));
        playerSkillList.add(new Skill("\uD83D\uDD2E 익스플로전", "마법", "불의 힘으로 적의 주위를 폭발시킵니다. ", 25, "마법사", 12, 50, 120, 0));
        playerSkillList.add(new Skill("\uD83D\uDD2E 선 버스트", "마법", "태양의 힘을 빌려 고온의 불꽃을 폭발시킵니다. ", 30, "마법사", 14, 50, 140, 0));
        playerSkillList.add(new Skill("\uD83E\uDE85 불의 손길", "마법", "불의 손을 만들어 붙잡아 태웁니다.", 35, "마법사", 16, 50, 160, 0));
        playerSkillList.add(new Skill("\uD83C\uDF87 메테오 샤워", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다.", 40, "마법사", 20, 50, 18, 0));


//        playerSkillList.add(new Skill("\uD83E\uDE85 마력 증폭", "마법", "마력을 높여 공격력을 높입니다. ",30,"마법사", 0, 20, 20, 30));
        //        playerSkillList.add(new Skill("\uD83D\uDC89 체력 회복", "마법", "체력을 회복합니다. ", 18,"마법사", 0,20, 20, 30));

        playerSkillList.add(new Skill("몽둥이 휘두르기", "물리", "몽둥이를 휘두릅니다", 1, "고블린", 0, 35, 0, 0));
        playerSkillList.add(new Skill("용액 뿌리기", "마법", "슬라임이 자신의 일부를 던집니다", 1, "슬라임", 0, 35, 0, 0));
        playerSkillList.add(new Skill("몸통박치기", "마법", "슬라임이 몸통박치기를 합니다. ", 1, "대왕슬라임", 0, 45, 0, 0));
        playerSkillList.add(new Skill("도끼 던지기", "물리", "도끼를 던집니다. ", 1, "홉고블린", 0, 55, 0, 0));
        playerSkillList.add(new Skill("산성 용액 뿌리기", "마법", "유성우를 떨어뜨려 높은 대미지를 입힙니다. ", 1, "산성슬라임", 0, 55, 0, 0));
        playerSkillList.add(new Skill("이판사판 휘두르기", "물리", "가지고 있는 무기를 전부 휘두릅니다.", 1, "킹고블린", 0, 65, 0, 0));
        playerSkillList.add(new Skill("검은 엄니", "물리", "유성우를 떨어뜨려 높은 대미지를 입힙니다. ", 1, "흑랑", 0, 75, 0, 0));
        playerSkillList.add(new Skill("노랫소리", "마법", "세이렌이 노래를 부릅니다. ", 1, "세이렌", 0, 75, 0, 0));
        playerSkillList.add(new Skill("내려치기", "물리", "주먹으로 내리칩니다. ", 1, "골렘", 0, 75, 0, 0));
        playerSkillList.add(new Skill("파일 드라이버", "물리", "골렘이 레슬링 기술을 씁니다. ", 1, "거대 골렘", 0, 85, 0, 0));
        playerSkillList.add(new Skill("임팩트 래리어트", "물리", "오우거의 전완근으로 목을 강타합니다. ", 1, "오우거", 0, 95, 0, 0));
        playerSkillList.add(new Skill("다크 레이", "마법", "마인의 3번째 눈에서 검은 빛줄기가 나옵니다.", 1, "마인", 0, 95, 0, 0));
        playerSkillList.add(new Skill("타락한 빛의 검", "마법", "타락한 천사가 빛의 검으로 내려칩니다. ", 1, "타천사", 0, 105, 0, 0));
        playerSkillList.add(new Skill("드래곤 브레스", "마법", "드래곤이 브레스를 뿜습니다 ", 1, "드래곤", 0, 110, 0, 0));

        //몬스터 스킬
    }

    public static SkillDB instance = new SkillDB();

    public static SkillDB getInstance() {
        return instance;
    }


    public ArrayList<Skill> getplayerSkillList() {
        return playerSkillList;
    }

    public void setplayerSkillList(ArrayList<Skill> playerSkillList) {
        this.playerSkillList = playerSkillList;
    }


    public SkillDB(ArrayList<Skill> skillList) {
        this.playerSkillList = skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.playerSkillList = skillList;
    }

    public static void setInstance(SkillDB instance) {
        SkillDB.instance = instance;
    }

    public ArrayList<Skill> getSkillList() {
        return playerSkillList;
    }

}
