package com.programmers.view;

import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void calculateResult(int result) {
        System.out.println(result + "\n");
    }

    public static void inquire(Map<Integer, String> results) {
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
