package com.devcourse.engine;

import com.devcourse.computer.Computer;
import com.devcourse.engine.io.Input;
import com.devcourse.engine.io.Output;
import com.devcourse.engine.model.Menu;
import com.devcourse.exception.InvalidInputException;
import com.devcourse.historian.Historian;
import lombok.AllArgsConstructor;

import java.util.Stack;

@AllArgsConstructor
public class Calculator implements Runnable {

    private Computer computer;
    private Historian historian;
    private Input input;
    private Output output;

    @Override
    public void run() {
        while (true) {
            String menu = input.inputMenu();

            if (menu.equals(Menu.EXIT.getMenuOrdinal())) {
                output.endGame();
                break;
            } else if (menu.equals(Menu.HISTORY.getMenuOrdinal())) {
                historian.showHistory();
            } else {
                String userInput = input.inputExpression();

                try {
                    computer.validate(userInput);
                    Stack<String> expression = computer.convert(userInput);
                    double result = computer.compute(userInput);
                    historian.saveHistory(expression, result);
                } catch (InvalidInputException e) {
                    output.printError(e.getMessage());
                }
            }

        }
    }
}
