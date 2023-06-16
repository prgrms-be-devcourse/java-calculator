package org.example.Calculate;

import java.util.Arrays;
import java.util.Stack;

public class PreProcessImpl implements PreProcess {
    Stack<String> expressionStack = new Stack<>();

    @Override
    public Stack<String> expressionToStack(String expression) {
        makeEmptyStack();
        Arrays.stream(expression.split(" "))
                .forEach(expressionStack::add);
        return expressionStack;
    }

    private void makeEmptyStack() {
        expressionStack.clear();
    }
}
