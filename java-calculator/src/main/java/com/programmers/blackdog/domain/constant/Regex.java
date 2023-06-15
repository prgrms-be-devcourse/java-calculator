package com.programmers.blackdog.domain.constant;

import com.programmers.blackdog.domain.RegexGenerator;

public final class Regex {

    private Regex(){
        throw new AssertionError("인스턴스화 할 수 없습니다!");
    }


    public static final String BLANK = " ";
    public static final String DELIMITER;
    public static final String REGEX;

    static {
        DELIMITER = " ";
        REGEX = new RegexGenerator().generateWithAllOperator();
    }
}
