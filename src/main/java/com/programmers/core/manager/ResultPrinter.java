package com.programmers.core.manager;

import com.programmers.view.Console;

public class ResultPrinter {
    private final Console console;

    public ResultPrinter(Console console) {
        this.console = console;
    }

    public void printResult(long result) {
        console.print(result);
    }
}
