package org.example.Calculate;

import java.util.Stack;

public class CalOrderImpl implements CalOrder {
    private int result = 0;
    Stack<String> expressionStack = new Stack<>();

    @Override
    public String calculateMultiplyDivide() {
        for (int i = 1; i < expressionStack.size(); i += 2) {
            if (expressionStack.get(i).equals("*")) {
                multiply(i);
                i -= 2;
            } else if (expressionStack.get(i).equals("/")) {
                divide(i);
                i -= 2;
            }
        }
        return expressionStack.toString();
    }

    @Override
    public int calculatePlusMinus() {
        result = Integer.parseInt(expressionStack.get(0));
        for (int i = 1; i < expressionStack.size(); i += 2) {
            if (expressionStack.get(i).equals("+")) {
                result += Integer.parseInt(expressionStack.get(i + 1));
            } else {
                result -= Integer.parseInt(expressionStack.get(i + 1));
            }
        }
        return result;
    }

    @Override
    public void setStack(Stack<String> expressionStack) {
        this.expressionStack = expressionStack;
    }

    private void multiply(int idx) {
        result = Integer.parseInt(expressionStack.get(idx - 1)) * Integer.parseInt(expressionStack.get(idx + 1));
        replaceNumOperatorNumWithResult(idx);
    }

    private void divide(int idx) {
        result = Integer.parseInt(expressionStack.get(idx - 1)) / Integer.parseInt(expressionStack.get(idx + 1));
        replaceNumOperatorNumWithResult(idx);
    }

    private void replaceNumOperatorNumWithResult(int idx) {
        expressionStack.add(idx - 1, String.valueOf(result));
        expressionStack.remove(idx);
        expressionStack.remove(idx);
        expressionStack.remove(idx);
    }
}
