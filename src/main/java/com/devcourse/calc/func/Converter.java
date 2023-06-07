package com.devcourse.calc.func;

import com.devcourse.calc.model.Operand;
import com.devcourse.calc.model.Operator;
import com.devcourse.calc.model.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Converter {

    public List<Token> infixToPostfixFormula(String origin) {
        String formula = origin.replace(" ", "");
        List<Token> result = new ArrayList<>();
        Stack<Operator> operatorStack = new Stack<>();

        for (char currentChar : formula.toCharArray()) {
            if (Character.isDigit(currentChar)) {
                result.add(new Operand(Character.getNumericValue(currentChar)));
                continue;
            }
            processOperator(result, operatorStack, currentChar);
        }

        return clearOperationStack(result, operatorStack);
    }

    private void processOperator(List<Token> result, Stack<Operator> operatorStack, char operatorChar) {
        Operator operator = Operator.find(operatorChar);
        if (operatorStack.size() > 0 && operator.isLowerPriority(operatorStack.peek())) {
            result.add(operatorStack.pop());
        }
        operatorStack.push(operator);

        if (operator.isFinishBracket()) {
            clearBracketFormula(result, operatorStack);
        }
    }

    private void clearBracketFormula(List<Token> result, Stack<Operator> operatorStack) {
        operatorStack.pop();
        while (!operatorStack.peek().isOpenBracket()) {
            result.add(operatorStack.pop());
        }
        operatorStack.pop();
    }

    private List<Token> clearOperationStack(List<Token> result, Stack<Operator> operatorStack) {
        while (!operatorStack.isEmpty()) {
            result.add(operatorStack.pop());
        }
        return result;
    }
}
