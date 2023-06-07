package com.devcourse.java.domain.console;

import static com.devcourse.java.domain.console.Messages.EXITING;
import static com.devcourse.java.domain.console.Messages.EXIT_CONFIRM;
import static com.devcourse.java.domain.console.Messages.MENU_SELECTION;

public class Console {
    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public int selectMenu() {
        output.print(MENU_SELECTION.toString());
        return input.readAsInt();
    }

    public String askIfExiting() {
        output.print(EXIT_CONFIRM.toString());
        return input.read();
    }

    public void exiting() {
        output.print(EXITING.toString());
    }
}
