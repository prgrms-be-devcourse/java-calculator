package com.programmers.calculator;

import com.programmers.calculator.domain.CalculationResult;
import com.programmers.calculator.domain.Operator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Calculator {
    private final CalculatorMemory calculatorMemory;

    public Calculator(CalculatorMemory calculatorMemory) {
        this.calculatorMemory = calculatorMemory;
    }

    public double calculate(String postfixExpression) {
        Deque<Double> operandStack = new ArrayDeque<>();

        Arrays.stream(postfixExpression.split(" "))
                .forEach(token -> {
                    if (Character.isDigit(token.charAt(0))) {
                        handleDigit(operandStack, token);
                    } else {
                        handleOperator(operandStack, token);
                    }
                });

        return operandStack.pop();
    }

    public void saveCalculationResult(CalculationResult calculationResult) {
        calculatorMemory.save(calculationResult);
    }

    public List<CalculationResult> findCalculationHistory() {
        return calculatorMemory.findAll();
    }

    private void handleDigit(Deque<Double> operandStack, String digit) {
        operandStack.push(Double.parseDouble(digit));
    }

    private void handleOperator(Deque<Double> operandStack, String symbol) {
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();

        Operator operator = Operator.findBySymbol(symbol);
        double result = operator.calculate(operand1, operand2);

        operandStack.push(result);
    }
}
