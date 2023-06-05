package com.devcourse.util;

import com.devcourse.calc.model.Number;
import com.devcourse.calc.model.Operator;
import com.devcourse.calc.model.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Converter {

    public static List<Token> infixToPostfixFormula(String origin) {
        origin = origin.replace(" ", "");
        List<Token> result = new ArrayList<>();
        Stack<Operator> stack = new Stack<>();

        for (int i = 0; i < origin.length(); i++) {
            char currentChar = origin.charAt(i);

            if (Character.isDigit(currentChar)) {
                result.add(new Number(Character.getNumericValue(currentChar)));
                continue;
            }

            Operator newOperator = Operator.find(currentChar);
            if (stack.size() > 0 && newOperator.isLowerPriority(stack.peek())) {
                result.add(stack.pop());
            }
            stack.push(newOperator);

            if (newOperator.isFinishBracket()) {
                clearBracketFormula(result, stack);
            }
        }

        return clearOperationStack(result, stack);
    }

    private static void clearBracketFormula(List<Token> result, Stack<Operator> stack) {
        stack.pop();
        while (!stack.peek().isOpenBracket()) {
            result.add(stack.pop());
        }
        stack.pop();
    }

    private static List<Token> clearOperationStack(List<Token> result, Stack<Operator> stack) {
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
