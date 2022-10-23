package com.project.java.engine.solver;

import com.project.java.exception.ZeroDivisionException;

import java.util.*;

public class StackSolver implements Solver {

    private static final String OPER_REGULAR = "[+\\-*/]";
    private static final String NUMBER_REGULAR = "[0-9]+";

    @Override
    public Map<Integer, List<String>> calculate(String expression) throws ZeroDivisionException {
        List<String> expressionList = makeExpressionToList(expression);
        List<String> postfix = makeInfixToPostfix(expressionList);
        int result = calculatePostfix(postfix);
        Map<Integer, List<String>> resultMap = new HashMap<>();
        resultMap.put(result, expressionList);
        return resultMap;
    }

    private List<String> makeInfixToPostfix(List<String> infix) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> postfix = new ArrayList<>();
        for (String element : infix) {
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                int priority = getPriority(element);
                while (!stack.isEmpty() && priority <= getPriority(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(element);
            } else {
                postfix.add(element);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }

    private int getPriority(String oper) {
        if (oper.equals("+") || oper.equals("-")) return 1;
        else return 2;
    }

    private List<String> makeExpressionToList(String expression) {
        ArrayList<String> splittedValues = new ArrayList<>();
        expression = expression.replace(" ", "");
        String[] nums = expression.split(OPER_REGULAR);
        String[] opers = expression.split(NUMBER_REGULAR);
        splittedValues.add(String.valueOf(Integer.parseInt(nums[0])));
        for (int i = 1; i < opers.length; i++) {
            splittedValues.add(opers[i]);
            splittedValues.add(String.valueOf(Integer.parseInt(nums[i])));
        }
        return splittedValues;
    }

    private int calculatePostfix(List<String> postfix) throws ZeroDivisionException {
        Stack<Integer> stack = new Stack<>();

        for (String element : postfix) {
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                if (element.equals("/") && second == 0) throw new ZeroDivisionException("0으로 나눌 수 없습니다.");
                switch (element) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(element));
            }
        }
        return stack.pop();
    }
}
