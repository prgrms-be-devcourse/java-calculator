package com.programmers.calculator.io;

import com.programmers.calculator.domain.Menu;

import java.util.Arrays;

public class ConsoleOutput implements Output {
    @Override
    public void displayMenu() {
        Arrays.stream(Menu.values())
                .forEach(menu -> System.out.println(menu.getMenuNumber() + ". " + menu.getText()));
        printEmptyLine();
    }

    @Override
    public <T> void displayResult(T result) {
        System.out.println(result);
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
