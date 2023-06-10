package com.devcourse.engine;

import com.devcourse.engine.computer.Computer;
import com.devcourse.engine.io.Input;
import com.devcourse.engine.io.Output;
import com.devcourse.engine.model.Menu;
import com.devcourse.engine.exception.InvalidInputException;
import com.devcourse.engine.historian.Historian;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

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

            try {

                if (menu.length() != 1)
                    throw new InvalidInputException("올바른 메뉴를 선택해주세요.");

                if (menu.equals(Menu.EXIT.getMenuOrdinal())) {

                    output.endGame();
                    break;

                } else if (menu.equals(Menu.HISTORY.getMenuOrdinal())) {

                    if (historian.getLastIndex() < 1) {
                        output.printError("표시할 이력이 없습니다.");
                        continue;
                    }

                    IntStream.rangeClosed(1, historian.getLastIndex())
                            .forEach(i -> output.showHistory(historian.getHistory(i)));
                    output.showHistory("");

                } else if (menu.equals(Menu.COMPUTE.getMenuOrdinal())) {

                    String userInput = input.inputExpression();
                    List<String> infixExpression = computer.validate(userInput);
                    List<String> postfixExpression = computer.convert(infixExpression);
                    double result = computer.compute(postfixExpression);

                    historian.saveHistory(infixExpression, result);
                    output.showResult(result);

                } else {
                    throw new InvalidInputException("올바른 메뉴를 선택해주세요.");
                }

            } catch (InvalidInputException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
