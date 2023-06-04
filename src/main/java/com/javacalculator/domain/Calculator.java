package com.javacalculator.domain;

import com.javacalculator.dto.CalculatorRequest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private Map<String, Integer> histories = new LinkedHashMap<>();

    public int calculate(CalculatorRequest request) {
        List<Integer> operands = request.getOperands();
        int priority = 0;
        while (operands.size() != 1) {
            calculateSub(operands, request.getOperators(), priority++);
        }

        saveHistory(request.getExpression(), operands.get(0));
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

    private void saveHistory(String expression, int result) {
        histories.put(expression, result);
    }

    public Map<String, Integer> getHistories() {
        return histories;
    }
}
