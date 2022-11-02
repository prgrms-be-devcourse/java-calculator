package com.programmers.kwonjoosung.java.calculator;

import com.programmers.kwonjoosung.java.calculator.io.Console;
import com.programmers.kwonjoosung.java.calculator.repository.Repository;
import com.programmers.kwonjoosung.java.calculator.service.ArithmeticCalculator;


public class Calculator {
    private final Console console;
    private final ArithmeticCalculator calculator;
    private final Repository calculationRepository;

    Calculator(ArithmeticCalculator calculator, Console console, Repository calculationRepository) {
        this.calculator = calculator;
        this.console = console;
        this.calculationRepository = calculationRepository;
    }

    public void run() {
        while (true) {
            try {
                if (select()) break;
                console.inputNext(); // 계속하려면 아무키나 입력하세요..
            } catch (Exception e) {
                console.printError(e.getMessage());
            }
        }
    }

    private boolean select() {
        switch (console.getMenu()) {
            case LOOKUP -> showHistory();
            case CALCULATE -> calculate();
            case EXIT -> {
                console.printExit();
                return true;
            }
            default -> console.printMenuError();
        }
        return false;
    }

    private void showHistory() {
        calculationRepository.findAll().forEach(console::println);
    }

    private void calculate() {
        String expression = console.inputExpression();
        String result = calculator.calculate(expression);
        calculationRepository.save(expression, result);
        console.println(result);
    }
}
