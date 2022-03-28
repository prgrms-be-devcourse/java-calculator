package com.programmers.calculator.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorService {
    public boolean checkNumsAndSymbol(String str) {
        String regex = "[^0-9+\\-*\\/\\s]|[\\s]{2,}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        return !m.find();
    }

    public boolean checkSymbolMatching(String str) {
        return str.split(" ").length % 2 != 0;
    }
}
