package com.javacalculator.util;

import java.util.LinkedList;
import java.util.List;

public class CalculatorSplitter {

    private static final String DELIMINATOR = " ";

    private CalculatorSplitter() {
    }

    public static List<Integer> splitToOperands(String expression) {
        String[] splits = expression.split(DELIMINATOR);

        List<Integer> operands = new LinkedList<>();
        for (int i = 0; i < splits.length; i++) {
            if (i % 2 == 0) {
                operands.add(StringParser.parseInt(splits[i]));
            }
        }
        return operands;
    }

    public static List<String> splitToOperators(String expression) {
        String[] splits = expression.split(DELIMINATOR);

        List<String> operators = new LinkedList<>();
        for (int i = 0; i < splits.length; i++) {
            if (i % 2 == 1) {
                operators.add(splits[i]);
            }
        }
        return operators;
    }
}
