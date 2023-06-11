package com.programmers.io;

import com.programmers.Menu;

import java.util.Arrays;

public class ConsoleOutput implements Output {
    @Override
    public void displayMenu() {
        Arrays.stream(Menu.values())
                .forEach(menu -> System.out.println(menu.getMenuNumber() + ". " + menu.getText()));
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
