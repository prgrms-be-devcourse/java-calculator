package com.javacalculator.view;

import com.javacalculator.domain.Menu;

import java.util.Map;

public class OutputView {

    private OutputView() {

    }

    public static void outputMenu() {
        for (Menu menu : Menu.values()) {
            System.out.printf("%d. %s%n", menu.getNumber(), menu.getName());
        }
    }

    public static void outputCalculatedResult(int result) {
        System.out.printf("%d%n%n", result);
    }

    public static void outputHistories(Map<String, Integer> histories) {
        for (String expression : histories.keySet()) {
            System.out.printf("%s = %d%n", expression, histories.get(expression));
        }
        System.out.println();
    }
}
