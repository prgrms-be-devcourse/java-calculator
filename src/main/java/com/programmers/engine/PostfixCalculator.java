package com.programmers.engine;

import java.util.Stack;
import java.util.function.Predicate;

public class PostfixCalculator {

    private final Stack<Character> opStack = new Stack<>();
    private final StringBuilder postFix = new StringBuilder();

    private double calculate(String equation) {
        Stack<Double> stack = new Stack<>();
        char cur = ' ';
        double value1, value2;

        for (int i = 0; i < equation.length(); i++) {
            cur = equation.charAt(i);
            if (Character.isDigit(cur)) {
                stack.push(Double.valueOf(cur) - 48);
            } else {
                value2 = Double.valueOf(stack.pop());
                value1 = Double.valueOf(stack.pop());

                switch (cur) {
                    // 스택에서 거꾸로 뽑기 때문에 value2를 먼저
                    case '+':
                        stack.push(value1 + value2);
                        break;
                    case '-':
                        stack.push(value1 - value2);
                        break;
                    case '*':
                        stack.push(value1 * value2);
                        break;
                    case '/':
                        stack.push(value1 / value2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // 메서드를 분리해야 하는지?
    public double infixToPostfix(String infix) {
        char cur = ' ';

        for (int i = 0; i < infix.length(); i++) {
            cur = infix.charAt(i);

            if (Character.isDigit(cur)) {
                postFix.append(cur);
            } else if (opStack.isEmpty()) {
                opStack.push(cur);
            } else {
                if (cur == '(') {
                    opStack.push(cur);
                    continue;
                }
                // 열린 소괄호를 만날때까지 모든 연산자 pop();
                if (cur == ')') {
                    boolean flag = true;
                    while (flag) {
                        if (!popOperator((Character c) -> c == '(', opStack.pop())) {
                            flag = false;
                        }
                    }
                continue;
                }

                if (compareOpPriority(opStack.peek(), cur) > 0) {
                    opStack.push(cur);
                } else {
                    popOperator((Integer data) -> data > 0, compareOpPriority(opStack.peek(), cur));
                    opStack.push(cur);
                }
            }
        }
        if (!opStack.isEmpty()) stackPop(' ');

        return calculate(postFix.toString());
    }

    private void stackPop(char oper) {
        while (!opStack.isEmpty()) {
            oper = opStack.pop();
            if (oper == '(') return;
            postFix.append(oper);
        }
    }

    private  <T> boolean popOperator(Predicate<T> predicate, T data) {
        while (!opStack.isEmpty()) {
            if (predicate.test(data)) return false;

            if (data instanceof Character) {
                postFix.append(data);
                return true;
            }

            postFix.append(opStack.pop());
        }
        return true;
    }

    private int getPriority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '(':
            case ')':
                return 0;

            default:
                return -1; // 여기까지 도달 안함
        }
    }

    private int compareOpPriority(char stackOp, char curOp) {
        int stackOpPriority = getPriority(stackOp);
        int curOpPriority = getPriority(curOp);

        if (stackOpPriority < curOpPriority) {
            return 1;
        } else if (stackOpPriority == curOpPriority) {
            return 0;
        } else {
            return -1;
        }

    }

}
