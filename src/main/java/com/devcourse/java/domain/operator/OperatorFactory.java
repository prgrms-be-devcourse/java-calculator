package com.devcourse.java.domain.operator;

import com.devcourse.java.common.Factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OperatorFactory implements Factory<Operator, String> {
    private static final Map<String, Operator> operators = new HashMap<>();

    public OperatorFactory() {
        initMap();
    }

    @Override
    public Operator create(String symbol) {
        return operators.get(symbol);
    }

    private void initMap() {
        Arrays.stream(Operators.values())
                .forEach(operator -> operators.put(operator.getSymbol(), operator.getOperator()));
    }
}
