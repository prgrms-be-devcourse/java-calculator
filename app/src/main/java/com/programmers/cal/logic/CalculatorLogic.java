package com.programmers.cal.logic;

import java.util.Stack;
import java.util.StringTokenizer;

public class CalculatorLogic {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVISION = "/";

    // 합 계산
    public static double Calculation(String formula) {
        Stack<Double> formulaStack = priorityCalculation(formula);
        double result = formulaStack.stream().mapToDouble(Double::doubleValue).sum();

        return result;
    }

    // 우선순위 계산
    private static Stack<Double> priorityCalculation(String formula) {

        Stack<Double> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(formula, " ");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            switch (token) {
                case PLUS:
                    stack.push(Double.parseDouble(st.nextToken()));
                    break;
                case MINUS:
                    stack.push(-1 * Double.parseDouble(st.nextToken()));
                    break;
                case MULTIPLY:
                    double mul = stack.pop();
                    stack.push(mul * Double.parseDouble(st.nextToken()));
                    break;
                case DIVISION:
                    double div = stack.pop();
                    stack.push(div / Double.parseDouble(st.nextToken()));
                    break;
                default:
                    stack.push(Double.parseDouble(token));
            }
        }

        return stack;
    }

}
