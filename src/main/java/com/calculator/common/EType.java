package com.calculator.common;

public enum EType {
    FIND(1), CAL(2), END(3);

    private final int num;
    EType(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
