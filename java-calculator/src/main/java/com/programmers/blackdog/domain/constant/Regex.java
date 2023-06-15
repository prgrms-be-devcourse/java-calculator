package com.programmers.blackdog.domain.constant;

import com.programmers.blackdog.domain.RegexGenerator;

public class Regex {
    public static final String BLANK = " ";
    public static final String DELIMITER;
    public static final String REGEX;

    static {
        DELIMITER = " ";
        REGEX = new RegexGenerator().generateWithAllOperator();
    }
}
