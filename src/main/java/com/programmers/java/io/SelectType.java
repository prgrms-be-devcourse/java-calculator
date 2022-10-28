package com.programmers.java.io;

import lombok.Getter;

@Getter
public enum SelectType {
    LOOKUP("1"),
    CALCULATE("2"),
    EXIT("3");

    private String select;

    SelectType(String select) {
        this.select = select;
    }

    public static SelectType getSelectType(String s) {
        for (SelectType type : SelectType.values()) {
            if (type.getSelect().equals(s)) return type;
        }
        throw new IllegalArgumentException("옳지 않은 입력입니다. 보기에 있는 숫자를 입력해주세요.");
    }
}
