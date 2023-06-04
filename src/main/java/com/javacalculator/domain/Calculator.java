package com.javacalculator.domain;

import java.util.List;

public class Calculator {

    public int calculate(List<Integer> operands, List<String> operators) {
        int priority = 0;
        while (operands.size() != 1) {
            calculateSub(operands, operators, priority++);
        }

        return operands.get(0);
    }

    private void calculateSub(List<Integer> operands, List<String> operators, int priority) {
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = Operator.from(operators.get(i));

            if (!operator.isSame(priority)) {
                continue;
            }

            int result = operator.operate(operands.get(i), operands.get(i + 1));
            operators.remove(i);
            operands.remove(i);
            operands.remove(i);
            operands.add(i, result);
            i -= 1;
        }
    }
}
