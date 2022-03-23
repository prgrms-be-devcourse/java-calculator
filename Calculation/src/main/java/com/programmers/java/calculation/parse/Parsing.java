package com.programmers.java.calculation.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parsing {

    List<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

    public String removeSpase(String input) {

        String resultInput = input.replaceAll(" ", "");

        return resultInput;
    }

    public List<String> makeArray(String input) {
        List<String> result = new ArrayList<>();

        int point = 0;
        for (int i = 1; i < input.length()-1; i++) {
            if (isContains(operator, input, i)) {
                result.add(input.substring(point, i));
                result.add(input.substring(i, i + 1));
                point = i + 1;
            }
        }
        result.add(input.substring(point));

        return result;
    }

    private boolean isContains(List<String> operator, String input, int index) {
        return operator.contains(String.valueOf(input.charAt(index)));
    }


}
