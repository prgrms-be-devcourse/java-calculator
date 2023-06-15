package com.bona.javacalculator.core.converter;

import com.bona.javacalculator.core.Operator;
import com.bona.javacalculator.core.Priority;
import com.bona.javacalculator.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements Converter {
    private final String WHITE_SPACE = "";
    private final Priority priorityFind = new Priority();

    @Override
    public List<String> convert(String input) {
        List<String> postfix = new ArrayList<>();
        String[] splitInput = input.split(WHITE_SPACE);

        Stack<String> stack = new Stack<>();

        for (int index = 0; index < splitInput.length; index++) {
            String pieceInput = splitInput[index];
            if (Operator.isOperator(pieceInput)) {
                pushOperator(pieceInput, postfix, stack);
            } else {
                pushNumber(pieceInput, postfix);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;

    }

    public void pushOperator(String operator, List<String> postfix, Stack<String> operatorStack) {
        if (operatorStack.isEmpty() || Priority.compareOperation(operatorStack.peek(), operator) > 0) {
            operatorStack.push(operator);
            return;
        }
        while (!operatorStack.isEmpty() && Priority.compareOperation(operatorStack.peek(), operator) <= 0) {
            postfix.add(operatorStack.pop());
        }
        operatorStack.push(operator);
    }


    public void pushNumber(String number, List<String> postfix) {
        if (!Validator.isNumber(number)) {
            throw new NumberFormatException();
        }
        postfix.add(number);
    }


}

