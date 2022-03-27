package com.programmers.java.calculator;

import com.programmers.java.calculator.model.ExpressionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {
    private Console console;

    private final int SEARCH = 1;
    private final int CALCULATE = 2;

    @Override
    public void run() {
        while (true) {
            console.printMenu();
            Integer number = console.selectMenu();
            switch (number){
                case SEARCH -> console.printLogs();
                case CALCULATE -> console.executeCalculation();
                default -> System.out.println("올바른 메뉴 값을 입력해주세요.");
            }
        }
    }
}
