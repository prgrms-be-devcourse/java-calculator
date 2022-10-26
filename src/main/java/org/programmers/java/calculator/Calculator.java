package org.programmers.java.calculator;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.io.Input;
import org.programmers.java.calculator.io.Output;
import org.programmers.java.calculator.model.Menu;

@RequiredArgsConstructor
public class Calculator implements Runnable {

    private final CalculatorController calculatorController = new CalculatorController();
    private final Input input = new Console();
    private final Output output = new Console();

    private boolean power = true;
    @Override
    public void run() {
        while (power) {
            output.printMeun();
            Menu menu = Menu.selectMenu(input.read());
            execution(menu);
        }
    }

    private void execution(Menu menu) {
        String answer = switch (menu) {
            case RECORD -> calculatorController.calculationResult();
            case CALCULATE -> calculate(input.read());
            case EXIT -> off();
            case ERROR -> "잘못된 입력 입니다.\n";
        };
        output.print(answer);
    }

    private String calculate(String input) {
        try {
            return calculatorController.calculate(input);
        } catch (IllegalArgumentException | IllegalStateException | ArithmeticException e) {
            return e.getMessage();
        }


    }

    private String off() {
        power = false;
        return "종료 합니다.";
    }

}

