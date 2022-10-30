package org.programmers.java.calculator;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.processing.Processing;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.model.Menu;

public class Calculator{

    private final Processing processing = new Processing();
    private final Console console = new Console();

    private boolean power = true;

    public void run() {
        while (power) {
            console.printMeun();
            Menu menu = Menu.selectMenu(console.read());
            execution(menu);
        }
    }

    private void execution(Menu menu) {
        String answer = switch (menu) {
            case MEMORY -> processing.getMemory();
            case CALCULATE -> calculate(console.read());
            case EXIT -> off();
            case ERROR -> "잘못된 입력 입니다.\n";
        };
        console.print(answer);
    }

    private String calculate(String input) {
        try {
            return processing.calculate(input);
        } catch (IllegalArgumentException | IllegalStateException | ArithmeticException e) {
            return e.getMessage();
        }
    }

    private String off() {
        power = false;
        return "종료 합니다.";
    }

}

