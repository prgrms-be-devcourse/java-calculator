package org.programmers.java.calculator;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.model.Menu;

@RequiredArgsConstructor
public class Calculator implements Runnable {

    private final CalculatorController calculatorController;
    private final Console console;
    private static boolean POWER = true;
    @Override
    public void run() {

        while (POWER) {
            console.printMeun();
            Menu menu = Menu.selectMenu(console.read());
            execution(menu);
        }
    }

    private void execution(Menu menu) {
        String result = switch (menu) {
            case RECORD -> calculatorController.record();
            case CALCULATE -> calculatorController.calculate(console.read());
            case EXIT -> off();
            case ERROR -> "잘못된 입력 입니다.\n";
        };

        console.print(result);
    }

    private String off() {
        POWER = false;
        return "종료 합니다.";
    }


}

