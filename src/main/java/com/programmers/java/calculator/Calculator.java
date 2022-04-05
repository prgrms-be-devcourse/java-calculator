package com.programmers.java.calculator;

import com.programmers.java.calculator.model.ExpressionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {
    private Console console;

    private final int INPUT_ERROR = -1;
    private final int SEARCH = 1;
    private final int CALCULATE = 2;

    @Override
    public void run() {
        Integer number = 0;
        while (number != INPUT_ERROR) {
            console.printMenu();
            number = console.selectMenu();
            switch (number){
                case SEARCH -> console.printLogs();
                case CALCULATE -> console.executeCalculation();
                case INPUT_ERROR -> console.printInputError();
            }
        }
    }
}
