package org.example.Calculate;

import java.util.Stack;

public class PreProcessImpl implements PreProcess{
    private String expression;
    Stack<String> expressionStack = new Stack<>();
    @Override
    public Stack<String> expressionToStack(String expression) {
        this.expression = expression;
        String[] expressionArr = expression.split(" ");
        expressionStack.clear();
        for (String inputVal : expressionArr) {
            expressionStack.add(inputVal);
        }
        return expressionStack;
    }
}
