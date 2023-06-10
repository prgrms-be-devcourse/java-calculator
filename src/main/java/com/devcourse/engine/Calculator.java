package com.devcourse.engine;

import com.devcourse.engine.computer.Computer;
import com.devcourse.engine.io.Input;
import com.devcourse.engine.io.Output;
import com.devcourse.engine.model.Menu;
import com.devcourse.engine.exception.InvalidInputException;
import com.devcourse.engine.historian.Historian;
import lombok.AllArgsConstructor;

import java.util.List;
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
                    List<String> expression1 = computer.validate(userInput);
                    Stack<String> expression2 = computer.convert(expression1);
                    double result = computer.compute(expression2);
                    historian.saveHistory(expression1, result);
                } catch (InvalidInputException e) {
                    output.printError(e.getMessage());
                }
            }
        }
    }
}
