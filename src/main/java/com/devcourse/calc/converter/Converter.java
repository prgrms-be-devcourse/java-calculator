package com.devcourse.calc.converter;

import com.devcourse.calc.model.Operand;
import com.devcourse.calc.model.Operator;
import com.devcourse.calc.model.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class Converter {

    public List<Token> convertFormula(String origin) {
        String formula = origin.replace(" ", "");
        List<Token> result = new ArrayList<>();
        Stack<Operator> operatorStack = new Stack<>();

        StringBuilder operandNumber = new StringBuilder();
        for (char currentChar : formula.toCharArray()) {
            if (Character.isDigit(currentChar)) {
                operandNumber.append(currentChar);
                continue;
            }
            result.add(new Operand(Integer.parseInt(operandNumber.toString())));
            operandNumber = new StringBuilder();
            processOperator(result, operatorStack, currentChar);
        }
        result.add(new Operand(Integer.parseInt(operandNumber.toString())));
        return clearOperationStack(result, operatorStack);
    }

    protected abstract void processOperator(List<Token> result, Stack<Operator> operatorStack, char operatorChar);

    private List<Token> clearOperationStack(List<Token> result, Stack<Operator> operatorStack) {
        while (!operatorStack.isEmpty()) {
            result.add(operatorStack.pop());
        }
        return result;
    }
}