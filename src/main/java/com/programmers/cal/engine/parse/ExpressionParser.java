package com.programmers.cal.engine.parse;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser implements Parser {

    @Override
    public List<String> getTokenList(String inputString) {

        char[] elements = inputString.replaceAll("\\p{Z}", "").toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(elements[0]);

        for (int i = 1; i < elements.length; i++) {
            if (Character.isDigit(elements[i])) {
                builder.append(elements[i]);
            } else {
                if (builder.length() == 0) {
                    builder.append(elements[i]);
                } else {
                    list.add(builder.toString());
                    list.add(String.valueOf(elements[i]));
                    builder.setLength(0);
                }
            }
        }

        list.add(builder.toString());

        return list;
    }
}
