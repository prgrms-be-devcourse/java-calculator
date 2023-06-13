package com.programmers.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {
    private static final String SEPARATOR = " ";

    public static List<String> convert(String formula) {
        List<String> postfix = new ArrayList<>();
        String[] splitFormula = formula.split(SEPARATOR);
        Stack<String> stack = new Stack<>();
        PostfixConverterHelper.checkEmptyFormula(splitFormula);

        for (int position = 0; position < splitFormula.length; position++) {
            String eachFormula = splitFormula[position];

            if (PostfixConverterHelper.isOperatorPositionCheck(position)) {
                PostfixConverterHelper.putOperator(eachFormula, postfix, stack);
            } else {
                PostfixConverterHelper.putOperand(eachFormula, postfix);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }
}
