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

    public String readExpression() {
        return input.read();
    }

    public int selectMenu() {
        output.print(MENU_SELECTION.toMessage());
        return input.readAsInt();
    }

    public String askIfExiting() {
        output.print(EXIT_CONFIRM.toMessage());
        return input.read();
    }

    public void print(String message) {
        output.print(message);
    }

    public void printList(List<String> results) {
        for (String result : results) {
            output.print(result);
        }
    }
}
