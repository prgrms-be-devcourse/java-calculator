package me.kimihiqq.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormulaProcessor {

    private FormulaProcessor() {
    }

    public static List<String> parseFormula(String formula) {
        String[] arr = formula.split(" ");
        return Arrays.stream(arr).collect(Collectors.toList());
    }

    public static void validateFormula(String formula) {
        if (!formula.matches("^(-?\\d+(\\.\\d+)?\\s[+\\-*/]\\s)*-?\\d+(\\.\\d+)?$")) {
            throw new IllegalArgumentException("Invalid formula! Please enter again.");
        }
    }
}
