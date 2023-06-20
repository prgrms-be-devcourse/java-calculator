package com.programmers.java.calculator.engine.model;

// 1. 조회, 2. 계산, 3. 종료
public enum MenuNums {
    RECORD(1),
    CALCULATE(2),
    EXIT(3),
    NOTVALID(4);

    private int menuNum;

    MenuNums(int menuNum) {
        this.menuNum = menuNum;
    }

    public static MenuNums getSelectedNum(int menuNum){
        switch (menuNum){
            case 1:
                return RECORD;
            case 2:
                return CALCULATE;
            case 3:
                return EXIT;
            default:
                return NOTVALID;
        }
    }

}
