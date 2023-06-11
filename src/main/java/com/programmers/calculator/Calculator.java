package com.programmers.calculator;

import com.programmers.converter.ExpressionConverter;
import com.programmers.io.Console;

import java.util.Optional;

public class Calculator {

    private final Accumulator accumulator;
    private final InMemory inMemory;
    private boolean power = true;

    public Calculator(ExpressionConverter expressionConverter) {
        accumulator = new Accumulator(expressionConverter);
        inMemory = new InMemory();
    }

    public void run() {
        while (power) {
            Console.printMenu();

            MenuType menu = makeMenu(Console.inputMenuNumber())
                    .orElseGet(() -> MenuType.NULL);

            switch (menu) {
                case HISTORY:
                    Console.printHistory(inMemory.findAll());
                    break;

                case CALCULATE:
                    String expression = Console.inputExpression();
                    accumulator.calculate(expression)
                            .ifPresent((result) -> {
                                inMemory.save(new CalcResult(expression, result));
                                Console.printResult(result);
                            });
                    break;

                case EXIT:
                    power = false;
                    Console.printExit();
                    break;

                default:
                    break;
            }
        }
    }

    private Optional<MenuType> makeMenu(String expression) {
        Optional<MenuType> menu = Optional.empty();
        try {
            menu = Optional
                    .ofNullable(MenuType.findMenuType(expression));
        } catch (IllegalArgumentException e) {
            Console.printError(e.getMessage());
        }
        return menu;
    }
}
