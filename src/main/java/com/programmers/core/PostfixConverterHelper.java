package com.programmers.core;

import com.programmers.util.StringUtil;

import java.util.List;
import java.util.Stack;

public class PostfixConverterHelper {

    public static void putOperator(String operator, List<String> postfix, Stack<String> operatorStack) {
        if (!Operators.isOperator(operator));

        if (operatorStack.isEmpty() || Priority.isNewOperatorPriorityHigher(operator, operatorStack)) {
            operatorStack.push(operator);
            return;
        }

        while (!operatorStack.isEmpty() && Priority.isNewOperatorPriorityLower(operator, operatorStack)) {
            postfix.add(operatorStack.pop());
        }

        operatorStack.push(operator);
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
