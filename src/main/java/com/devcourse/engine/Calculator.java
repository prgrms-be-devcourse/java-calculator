package com.devcourse.engine;

import com.devcourse.engine.io.InputConsole;
import com.devcourse.engine.io.OutputConsole;
import com.devcourse.engine.model.accepter.Accepter;
import com.devcourse.engine.model.computer.Computer;
import com.devcourse.engine.model.converter.Converter;
import com.devcourse.engine.model.exception.InvalidInputException;
import com.devcourse.engine.model.histories.Histories;
import com.devcourse.engine.model.validator.Validator;
import com.devcourse.engine.model.unit.Menu;

import java.util.List;
import java.util.stream.IntStream;

import static com.devcourse.engine.model.exception.InvalidInputException.NO_HISTORY;

public class Calculator implements Runnable {

    private final InputConsole input;
    private final OutputConsole output;
    private final Histories histories;
    private final Accepter accepter;
    private final Converter converter;
    private final Computer computer;

    public Calculator(
            InputConsole input,
            OutputConsole output,
            Histories histories,
            Accepter accepter,
            Converter converter,
            Computer computer
            ) {
        this.input = input;
        this.output = output;
        this.histories = histories;
        this.accepter = accepter;
        this.converter = converter;
        this.computer = computer;
    }

    @Override
    public void run() {
        while (true) {
            String menu = input.inputMenu();
            if (actualOperate(menu)) {
                break;
            }
        }
    }

    private boolean actualOperate(String menu) {
        try {
            return menuOperate(menu);
        } catch (InvalidInputException e) {
            output.printError(e.getMessage());
        }
        return false;
    }

    private boolean menuOperate(String menu) {
        return switch (Menu.getMenuByOrdinalString(menu)) {
            case EXIT -> {
                output.endGame();
                yield true;
            }
            case HISTORY -> {
                checkHasHistory();
                printHistory();
                yield false;
            }
            case CALCULATE -> {
                calculate();
                yield false;
            }
        };
    }

    private void calculate() {
        String userInput = input.inputExpression();
        new Validator().validate(userInput);
        List<String> infixExpressions = accepter.accept(userInput);
        double result = computer.compute(
                converter.convert(infixExpressions)
        );
        saveAndPrint(infixExpressions, result);
    }

    private void saveAndPrint(List<String> infixExpressions, double result) {
        histories.saveHistory(infixExpressions, result);
        output.showResult(result);
    }

    private void printHistory() {
        IntStream.rangeClosed(1, histories.getLastIndex())
                .forEach(i -> output.showHistory(i, histories.getHistory(i)));
        output.printNewLine();
    }

    private void checkHasHistory() {
        if (histories.getLastIndex() < 1) {
            throw new InvalidInputException(NO_HISTORY);
        }
    }

}
