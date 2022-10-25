package com.programmers.cal.engine.parse;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParse implements Parse {

    @Override
    public List<String> getTokenList(String inputString) {

        char[] arr = inputString.replaceAll("\\p{Z}", "").toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                builder.append(arr[i]);
            } else {
                if (builder.length() == 0) {
                    builder.append(arr[i]);
                } else {
                    list.add(builder.toString());
                    list.add(String.valueOf(arr[i]));
                    builder.setLength(0);
                }
            }
        }

        list.add(builder.toString());

        return list;
    }
}
