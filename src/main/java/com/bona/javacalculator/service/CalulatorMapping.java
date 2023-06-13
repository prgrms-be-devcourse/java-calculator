package com.bona.javacalculator.service;

import com.bona.javacalculator.Operator;

import java.util.HashMap;
import java.util.Map;

public class CalulatorMapping {
    private static Map<Character, Operator> operatorMapping = new HashMap<>();

    static{
        operatorMapping.put('+', Operator.PLUS);
        operatorMapping.put('-', Operator.MINUS);
        operatorMapping.put('*', Operator.MULTIPLY);
        operatorMapping.put('/', Operator.DIVIDE);
    }

    public static Operator getOperator(Character operator) {
        return operatorMapping.get(operator);
    }

}
