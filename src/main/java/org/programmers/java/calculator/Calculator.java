package org.programmers.java.calculator;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.model.Menu;

@RequiredArgsConstructor
public class Calculator implements Runnable {

    private final CalculatorController calculatorController;
    private final Console console;
    @Override
    public void run() {
        console.printMeun();
        Menu menu = Menu.selectMenu(console.read());
        execution(menu);
    }

    private void execution(Menu menu) {
        String result = switch (menu) {
            case RECORD -> calculatorController.record();
            case CALCULATE -> null;
            case ERROR -> "잘못된 입력 입니다.\n";
        };

        console.print(result);
    }


}

