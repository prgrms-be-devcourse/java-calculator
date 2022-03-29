package com.programmers.oop.utils;

import java.util.Optional;

import com.programmers.oop.type.Operator;

public class OperatorUtils {

    public static Operator getOperator(char operator) {
        return Optional.of(Operator.getValue(operator))
            .orElseThrow(() -> new RuntimeException("not found resources .. "));
    }

    public static boolean isProperOpertatorYn(char operator) {
        return Operator.getValue(operator) != null;
    }

}
