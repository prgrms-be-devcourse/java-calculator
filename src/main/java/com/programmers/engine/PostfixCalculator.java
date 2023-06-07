package com.programmers.engine;

import java.util.Stack;

public class PostfixCalculator {

    //OOP를 잘 지킨걸까?
    public double calculate(String postfix) {
        Stack<Double> stack = new Stack<>();
        char cur = ' ';
        double value1, value2;

        for (int i = 0; i < postfix.length(); i++) {
            cur = postfix.charAt(i);
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
        Stack<Character> opStack = new Stack<>();
        StringBuilder postFix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            cur = infix.charAt(i);

            if (opStack.isEmpty() && !Character.isDigit(cur)) {
                opStack.push(cur);
            } else if (!opStack.isEmpty() && !Character.isDigit(cur)) {
                if (cur == '(') {
                    opStack.push(cur);
                    continue;
                } else if (cur == ')') {
                    char stackOperator = ' ';
                    while (true) {
                        stackOperator = opStack.pop();
                        if (stackOperator == '(') {
                            break;
                        }else {
                            postFix.append(stackOperator);
                        }
                    }
                    continue;
                }

                // 연산 우선순위가 높기 때문에 바로 추가
                if (compareOperator(opStack.peek(), cur) > 0) {
                    opStack.push(cur);
                }
                else{
                    while (!opStack.isEmpty()) {
                        if (compareOperator(opStack.peek(), cur) <= 0) {
                            postFix.append(opStack.pop());
                        } else {
                            break;
                        }
                    }
                    // 위에서 우선순위가 낮은 연산자를 다 빼낸 후 추가
                    opStack.push(cur);
                }
            }
            // 숫자 추가
            else {
                postFix.append(cur);
            }
        }

        char stackOperator = ' ';
        while (!opStack.isEmpty()) {
            stackOperator = opStack.pop();
            if (stackOperator != '(') {
                postFix.append(stackOperator);
            }
        }
        return calculate(postFix.toString());
    }

    public int getPriority(char op) {
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

    private int compareOperator(char stackOp, char curOp) {
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
