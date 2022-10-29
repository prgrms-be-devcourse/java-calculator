package com.programmers.java.calculator;

import com.programmers.java.exception.CalculateException;
import lombok.Getter;

import java.util.function.BiFunction;

@Getter
public enum CalculateType {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> {
        if (num2.intValue() == 0) throw new CalculateException("0으로 나눌 수 없습니다.");
        return num1 / num2;
    });

    private String operation;
    private BiFunction<Double, Double, Double> simpleCalculation;

    CalculateType(String operation, BiFunction<Double, Double, Double> simpleCalculation) {
        this.operation = operation;
        this.simpleCalculation = simpleCalculation;
    }


    public Double doOperation(double num1, double num2, CalculateType type) {
        return type.simpleCalculation.apply(num1, num2);
    }

    public static CalculateType getOperator(String o) {
        for (CalculateType type : CalculateType.values()) {
            if (type.getOperation().equals(o)) return type;
        }
        throw new CalculateException("잘못된 연산자입니다.");
    }


}
