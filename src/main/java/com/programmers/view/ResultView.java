package com.programmers.view;

import java.util.Map;

public class ResultView {
    private static final String MIDDLEMAN = " = ";
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void calculateResult(int result) {
        System.out.println(result + "\n");
    }

    public static void inquire(Map<String, Integer> results) {
        for (String input : results.keySet()) {
            stringBuilder.append(input + MIDDLEMAN + results.get(input) + "\n");
        }

        System.out.println(stringBuilder.toString());
    }

}
