package com.javacalculator.view;

import com.javacalculator.domain.Menu;

public class OutputView {

    private OutputView() {

    }

    public static void outputMenu() {
        for (Menu menu : Menu.values()) {
            System.out.printf("%d. %s%n", menu.getNumber(), menu.getName());
        }
    }
}
