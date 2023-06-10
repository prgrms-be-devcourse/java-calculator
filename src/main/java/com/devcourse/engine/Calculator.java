package com.devcourse.engine;

import com.devcourse.engine.computer.Computer;
import com.devcourse.engine.io.Input;
import com.devcourse.engine.io.Output;
import com.devcourse.engine.model.Menu;
import com.devcourse.engine.exception.InvalidInputException;
import com.devcourse.engine.historian.Historian;
import lombok.AllArgsConstructor;

import java.util.List;

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
                output.showHistory(historian.getHistory());
            } else {
                String userInput = input.inputExpression();

                try {
                    List<String> infixExpression = computer.validate(userInput);
                    List<String> postfixExpression = computer.convert(infixExpression);
                    double result = computer.compute(postfixExpression);
                    historian.saveHistory(infixExpression, result);
                    output.showResult(result);
                } catch (InvalidInputException e) {
                    output.printError(e.getMessage());
                }
            }
        }
    }
}
