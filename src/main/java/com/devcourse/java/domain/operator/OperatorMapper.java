package com.devcourse.java.domain.operator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OperatorMapper {
    private static final Map<String, Operator> operators = new HashMap<>();

    public OperatorMapper() {
        initMap();
    }

    public Operator toOperator(String symbol) {
        return operators.get(symbol);
    }

    private void initMap() {
        Arrays.stream(OperatorType.values())
                .forEach(operator -> operators.put(operator.getSymbol(), operator.getOperator()));
    }
}
