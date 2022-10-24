package com.project.java.engine.solver;

import com.project.java.engine.converter.StringExpressionConverter;
import com.project.java.engine.data.ResultFormat;
import com.project.java.exception.ZeroDivisionException;

import java.util.*;

public class StackSolver implements Solver {

    private static final String OPER_REGULAR = "[+\\-*/]";
    private static final String NUMBER_REGULAR = "[0-9]+";

    @Override
    public ResultFormat calculate(String expression) throws ZeroDivisionException {
        List<String> expressionList = makeExpressionToList(expression);
        List<String> postfix = makeInfixToPostfix(expressionList);
        double result = calculatePostfix(postfix);

        String convertedExpression = new StringExpressionConverter<String>(expressionList).convert();

        return new ResultFormat(convertedExpression, result);
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
        // 0001 0002 제거하기 위해 Long.parseLong 후 String.valueOf
        splittedValues.add(String.valueOf(Long.parseLong(nums[0])));
        for (int i = 1; i < opers.length; i++) {
            splittedValues.add(opers[i]);
            splittedValues.add(String.valueOf(Long.parseLong(nums[i])));
        }
        return splittedValues;
    }

    private double calculatePostfix(List<String> postfix) throws ZeroDivisionException {
        Stack<Double> stack = new Stack<>();

        for (String element : postfix) {
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                double second = stack.pop();
                double first = stack.pop();
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
                stack.push(Double.parseDouble(element));
            }
        }
        return stack.pop();
    }
}
