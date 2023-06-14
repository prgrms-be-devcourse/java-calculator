package com.programmers.service;

import com.programmers.engine.PostfixCalculator;
import com.programmers.repository.CalculatorHistory;

import java.util.Map;

public class CalculatorService {
    private CalculatorHistory calculatorHistory;
    private PostfixCalculator postfixCalculator;

    public CalculatorService(CalculatorHistory calculatorHistory, PostfixCalculator postfixCalculator) {
        this.calculatorHistory = calculatorHistory;
        this.postfixCalculator = postfixCalculator;
    }

    public double calculate(String equation) {
        return postfixCalculator.infixToPostfix(equation);
    }

    public void save(String equation, double answer) {
        calculatorHistory.save(equation, answer);
    }

    public Map<String, Double> showHistory() {
        return calculatorHistory.findAll();
    }
}
