package org.example.domain;

import java.util.List;

public class Calculator {

    private ExpressionConvertor expressionConvertor;
    private CalculateExecuter calculateExecuter;
    private History history;

    public Calculator() {
        this.expressionConvertor = new ExpressionConvertor();
        this.calculateExecuter = new CalculateExecuter();
        this.history = new History();
    }

    public Integer execute(String expression) {
        Integer result = calculateExecuter.calculate(expressionConvertor.convertToPostfix(expression));

        history.save(expression, result);
        return result;
    }

    public List<String> getHistory() {
        return history.getHistory();
    }
}
