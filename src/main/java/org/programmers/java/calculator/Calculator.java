package org.programmers.java.calculator;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.model.Menu;

@RequiredArgsConstructor
public class Calculator implements Runnable {

    private final CalculatorController calculatorController;
    private final Console console;
    private boolean power = true;
    @Override
    public void run() {
        while (power) {
            console.printMeun();
            Menu menu = Menu.selectMenu(console.read());
            execution(menu);
        }
    }

    private void execution(Menu menu) {
        String answer = switch (menu) {
            case RECORD -> calculatorController.calculationResult();
            case CALCULATE -> calculatorController.calculate(console.read());
            case EXIT -> off();
            case ERROR -> "잘못된 입력 입니다.\n";
        };
        console.print(answer);
    }

    private String off() {
        power = false;
        return "종료 합니다.";
    }


}

