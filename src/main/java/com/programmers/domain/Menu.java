package com.programmers.domain;

import java.util.Arrays;

public enum Menu {
    HISTORY(1,"조회"),
    CALCULATE(2,"계산"),
    FINISH(3,"종료");

    private final int num;
    private final String name;

    Menu(int num, String name){
        this.num = num;
        this.name = name;
    }

    public int getNum(){
        return num;
    }
    public String getName(){
        return name;
    }
    public boolean isHistory(){
        if(this.num == 1) return true;
        return false;
    }

    public boolean isFinish(){
        if(this.num == 3) return true;
        return false;
    }

    public boolean isCalculate(){
        if(this.num == 2) return true;
        return false;
    }

    public static Menu getMenu(int num){
        return Arrays.stream(Menu.values()).filter(m -> m.num == num).findAny().get();
    }

}
