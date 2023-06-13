package com.bona.javacalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

import static com.bona.javacalculator.service.CalulatorMapping.getOperator;

public enum Operator {
    PLUS((num1, num2) -> num1 + num2),
    MINUS((num1,num2) -> num1 - num2),
    MULTIPLY((num1, num2) -> num1 * num2),
    DIVIDE((num1,num2) -> num1 / num2);

    private BiFunction<Double,Double,Double> expression;

    Operator(BiFunction<Double,Double,Double> expression){
        this.expression = expression;
    }

    public static double calculate(Character operator, double num1, double num2) {
        return getOperator(operator).expression.apply(num1, num2);
    }


}
