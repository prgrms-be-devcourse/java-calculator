package org.example.domain;

import java.util.List;

public class Calculator {

    private final ExpressionConvertor expressionConvertor;
    private final CalculateExecuter calculateExecuter;
    private final HistoryInterface history;

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
