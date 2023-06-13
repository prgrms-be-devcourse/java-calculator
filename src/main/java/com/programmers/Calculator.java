package com.programmers;

import com.programmers.domain.CalculationResult;
import com.programmers.domain.Operator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {
    private final CalculatorMemory calculatorMemory;

    public Calculator(CalculatorMemory calculatorMemory) {
        this.calculatorMemory = calculatorMemory;
    }

    public double calculate(String postfixExpression) {
        Deque<Double> operandStack = new ArrayDeque<>();

        postfixExpression.chars()
                .mapToObj(token -> (char) token)
                .forEach(token -> {
                    if (Character.isDigit(token)) {
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

    private void handleDigit(Deque<Double> operandStack, char digit) {
        double operand = Character.getNumericValue(digit);
        operandStack.push(operand);
    }

    private void handleOperator(Deque<Double> operandStack, char symbol) {
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();

        Operator operator = Operator.findBySymbol(symbol);
        double result = operator.calculate(operand1, operand2);

        operandStack.push(result);
    }
}
