package com.programmers.util;

import com.programmers.domain.model.Calculation;

import java.util.Arrays;
import java.util.List;

public class CalculatiorTestUtil {
    public static Calculation createCalculation(String expression, int result) {
        List<String> expressionList = Arrays.stream(expression.split(" ")).toList();

        return new Calculation(expressionList, result);
    }
}
