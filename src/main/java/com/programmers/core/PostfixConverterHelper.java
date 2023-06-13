package com.programmers.core;

import com.programmers.util.StringUtil;

import java.util.List;
import java.util.Stack;

public class PostfixConverterHelper {
    public static void putOperator(String operator, List<String> postfix, Stack<String> stack) {
        if (!Operators.isOperator(operator)) throw new IllegalArgumentException();

        if (stack.isEmpty() || Priority.getPriority(stack.peek()) < Priority.getPriority(operator)) {
            stack.push(operator);
            return;
        }

        while (!stack.isEmpty() && Priority.getPriority(stack.peek()) >= Priority.getPriority(operator)) {
            postfix.add(stack.pop());
        }

        stack.push(operator);
    }

    public static void putOperand(String operand, List<String> postfix) {
        if (!StringUtil.isNumber(operand)) {
            throw new NumberFormatException();
        }
        postfix.add(operand);
    }


    public static boolean isOperatorPositionCheck(int position) {
        return (position + 1) % 2 == 0;
    }

    public static void checkEmptyFormula(String[] splitFormula) {
        if (isEmptyFormula(splitFormula)) ;
    }

    public static boolean isEmptyFormula(String[] splitFormula) {
        return splitFormula != null && splitFormula.length == 0;
    }
}
