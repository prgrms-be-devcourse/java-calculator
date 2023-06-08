package com.devcourse.java.domain.console;

import java.util.List;

import static com.devcourse.java.common.Messages.EXIT_CONFIRM;
import static com.devcourse.java.common.Messages.MENU_SELECTION;

public class Console {
    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public String menuSelect() {
        output.print(MENU_SELECTION.toMessage());
        return input.read();
    }

    public String confirmExiting() {
        output.print(EXIT_CONFIRM.toMessage());
        return input.read();
    }

    public String read() {
        return input.read();
    }

    public void print(String message) {
        output.print(message);
    }

    public void print(Number number) {
        output.print(number);
    }

    public void printList(List<String> results) {
        for (String result : results) {
            output.print(result);
        }
        System.out.println();
    }
}
