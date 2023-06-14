package com.programmers.util;

import com.programmers.domain.Operator;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculatorProcessor {
    private static final Deque<Integer> operands = new ArrayDeque<>();
    private static final Deque<Operator> operators = new ArrayDeque<>();

    public static int calculateExpression(String postfix) throws ArithmeticException {

        String[] tokens = postfix.split("");

        for (String token : tokens) {
            //연산자
            if (Validator.isOperator(token)) {
                Operator operator = Operator.getOperator(token);
                while (!operators.isEmpty() && !Operator.isHigherPriority(operator)) {
                    int result = calculate();
                    operands.push(result);
                }
                operators.push(operator);
            }
            //숫자
            if (Validator.isInteger(token)) {
                operands.push(Integer.parseInt(token));
            }
        }

        while (!operators.isEmpty()) {
            int result = calculate();
            operands.push(result);
        }
        return operands.pop();

    }

    private static int calculate() {
        int second = operands.pop();
        int first = operands.pop();
        Operator operator = operators.pop();
        int result = operator.applyOperation(first, second);

        return result;
    }


}
