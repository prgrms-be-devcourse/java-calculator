package com.programmers.calculator.engine.repository;

import com.programmers.calculator.engine.io.Output;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExpressionAndResult {
    private Map<String, Integer> expressionAndResult = new LinkedHashMap<>();
    private Output output;

    public ExpressionAndResult(Output output) {
        this.output = output;
    }

    public void put(String expression, int result) {
        expressionAndResult.put(expression, result);
    }

    public void print() {
        Iterator<String> itr = expressionAndResult.keySet().iterator();

        while(itr.hasNext()) {
            String expression = itr.next();
            int result = expressionAndResult.get(expression);
            output.printExpressionAndResult(expression, result);
        }
    }
}
