package com.programmers.calculator.engine.repository;

import com.programmers.calculator.engine.io.Output;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExpressionAndResult {
    private final Map<String, Integer> expressionAndResult = new LinkedHashMap<>();
    private final Output output;

    public ExpressionAndResult(Output output) {
        this.output = output;
    }

    // 추가
    public void put(String expression, int result) {
        expressionAndResult.put(expression, result);
    }

    // 출력
    public void print() {
        for (String expression : expressionAndResult.keySet()) {
            int result = expressionAndResult.get(expression);
            output.printExpressionAndResult(expression, result);
        }
    }
}
