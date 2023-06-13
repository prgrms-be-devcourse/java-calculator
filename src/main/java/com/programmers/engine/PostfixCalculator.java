package com.programmers.engine;

import com.programmers.exception.DivideByZeroException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;

public class PostfixCalculator {
    private final String operators = "+-/*()";
    private final Stack<Character> opStack = new Stack<>();

    private double calculate(List<String> postfix) {

        Stack<Double> stack = new Stack<>();
        String cur = "";
        double value1, value2;

        for (int i = 0; i < postfix.size(); i++) {
            cur = postfix.get(i);
            if (!operators.contains(cur)) {
                stack.push(Double.valueOf(cur));
            } else {
                value2 = Double.valueOf(stack.pop());
                value1 = Double.valueOf(stack.pop());

                switch (cur) {
                    // 스택에서 거꾸로 뽑기 때문에 value2를 먼저
                    case "+":
                        stack.push(value1 + value2);
                        break;
                    case "-":
                        stack.push(value1 - value2);
                        break;
                    case "*":
                        stack.push(value1 * value2);
                        break;
                    case "/":
                        if (value2 == 0) throw new DivideByZeroException();
                        stack.push(value1 / value2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public double infixToPostfix(String infix) {

        List<String> postfix = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char cur = ' ';
            cur = infix.charAt(i);

            if (Character.isDigit(cur)) {
                sb.append(cur);
                if (i == infix.length() - 1) postfix.add(sb.toString());
            } else if (opStack.isEmpty()) {
                if (sb.length() > 0) {
                    postfix.add(sb.toString());
                    sb.setLength(0);
                }
                opStack.push(cur);
            } else {
                if (sb.length() > 0) {
                    postfix.add(sb.toString());
                    sb.setLength(0);
                }
                if (cur == '(') {
                    opStack.push(cur);
                    continue;
                }
                // 열린 소괄호를 만날때까지 모든 연산자 pop();
                if (cur == ')') {
                    boolean flag = true;
                    while (flag) {
                        if (!popOperator(postfix, (Character c) -> c == '(', opStack.peek())) {
                            flag = false;
                        }
                    }
                    continue;
                }

                if (compareOpPriority(opStack.peek(), cur) > 0) {
                    opStack.push(cur);
                } else {
                    popOperator(postfix, (Integer data) -> data > 0, compareOpPriority(opStack.peek(), cur));
                    opStack.push(cur);
                }
            }
        }
        if (!opStack.isEmpty()) stackPop(postfix,' ');

        return calculate(postfix);
    }

    private void stackPop(List<String> list, char oper) {
        while (!opStack.isEmpty()) {
            oper = opStack.pop();
            if (oper == '(') return;
            list.add(String.valueOf(oper));
        }
    }

    private <T> boolean popOperator(List<String> list, Predicate<T> predicate, T data) {
        while (!opStack.isEmpty()) {
            if (predicate.test(data)) {
                opStack.pop();
                return false;
            }

            if (data instanceof Character) {
                list.add(String.valueOf(opStack.pop()));
                return true;
            }

            list.add(String.valueOf(opStack.pop()));
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
