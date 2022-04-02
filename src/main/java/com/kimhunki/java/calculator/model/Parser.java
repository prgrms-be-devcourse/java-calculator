package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.enums.MenuNumber;
import com.kimhunki.java.calculator.enums.Operations;
import com.kimhunki.java.calculator.strategy.ParserStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements ParserStrategy {
    public MenuNumber menuParser(String selectString) {
        if (selectString.equals("1")) return MenuNumber.ONE;
        else if (selectString.equals("2")) return MenuNumber.TWO;
        else if (selectString.equals("3")) return MenuNumber.THREE;
        else return MenuNumber.NOTNUM;
    }

    public List<String> expressionParser(String expression) {
        List<String> list = new ArrayList<>();
        Matcher matcher = RegularExpressionPattern.pattern.matcher(expression);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public Operations operParser(String operation) {
        if (operation.equals("+")) return Operations.PLUS;
        else if (operation.equals("-")) return Operations.MINUS;
        else if (operation.equals("*")) return Operations.MUL;
        else return Operations.DIV;
    }
}
