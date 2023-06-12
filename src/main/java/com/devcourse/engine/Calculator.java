package com.devcourse.engine;

import com.devcourse.engine.computer.Computer;
import com.devcourse.engine.io.Input;
import com.devcourse.engine.io.Output;
import com.devcourse.engine.exception.InvalidInputException;
import com.devcourse.engine.historian.Historian;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.devcourse.engine.exception.InvalidInputException.INVALID_MENU;
import static com.devcourse.engine.exception.InvalidInputException.NO_HISTORY;

public class Calculator implements Runnable {

    private final Computer computer;
    private final Historian historian;
    private final Input input;
    private final Output output;

    public Calculator(
            Computer computer,
            Historian historian,
            Input input,
            Output output) {
        this.computer = computer;
        this.historian = historian;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        label:
        while (true) {
            String menu = input.inputMenu();

            try {
                validMenuCheck(menu);

                switch (menu) {
                    case "0":
                        output.endGame();
                        break label;
                    case "1":
                        checkHasHistory();
                        printHistory();
                        break;
                    case "2":
                        calculate();
                        break;
                }
            } catch (InvalidInputException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private void calculate() {
        String userInput = input.inputExpression();
        List<String> infixExpression = computer.validate(userInput);
        List<String> postfixExpression = computer.convert(infixExpression);
        double result = computer.compute(postfixExpression);

        historian.saveHistory(infixExpression, result);
        output.showResult(result);
    }

    private void printHistory() {
        IntStream.rangeClosed(1, historian.getLastIndex())
                .forEach(i -> output.showHistory(historian.getHistory(i)));
        output.showHistory("");
    }

    private void checkHasHistory() {
        if (historian.getLastIndex() < 1)
            throw new InvalidInputException(NO_HISTORY);
    }

    private void validMenuCheck(String menu) throws InvalidInputException {
        if (menu.length() > 1 || !Arrays.asList("0", "1", "2").contains(menu))
            throw new InvalidInputException(INVALID_MENU);
    }
}
