package com.programmers.cal.engine.parse;

import com.programmers.cal.engine.model.InputData;
import com.programmers.cal.engine.model.OriginalExpression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser implements Parser {

    @Override
    public OriginalExpression getTokenList(InputData inputData) {

        char[] elements = inputData.getInputString().replaceAll("\\p{Z}", "").toCharArray();
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

        return OriginalExpression.builder()
                .inputExpression(inputData)
                .originalTokens(list)
                .build();
    }
}
