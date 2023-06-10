package com.programmers.calculator;

import com.programmers.converter.ExpressionConverter;
import com.programmers.io.Console;

import java.util.Optional;

public class Calculator {

    private final Accumulator accumulator;
    private final Memory memory;
    private boolean power = true;

    public Calculator(ExpressionConverter expressionConverter) {
        accumulator = new Accumulator(expressionConverter);
        memory = new Memory();
    }

    public void run() {
        while (power) {
            Console.printMenu();

            MenuType menu = makeMenu(Console.inputMenuNumber())
                    .orElse(MenuType.NULL);

            switch (menu) {
                case HISTORY:
                    Console.printHistory(memory.findAll());
                    break;

                case CALCULATE:
                    String expression = Console.inputExpression();
                    String result = calculate(expression);
                    if (result == null) {
                        break;
                    }
                    memory.save(new CalcResult(expression, result));
                    Console.printResult(result);
                    break;

                case EXIT:
                    power = false;
                    Console.printExit();
                    break;

                default:
                    Console.printError("1, 2, 3 만 입력이 가능합니다.");
                    break;
            }
        }
    }

    private Optional<MenuType> makeMenu(String expression) {
        Optional<MenuType> menu = Optional.empty();
        try {
            menu = Optional.ofNullable(MenuType.findMenuType(expression));
        } catch (IllegalArgumentException e) {
            Console.printError(e.getMessage());
        }
        return menu;
    }

    private String calculate(String expression) {
        String result = null;
        try {
            result = accumulator.compute(expression);
        } catch (IllegalArgumentException | ArithmeticException e) {
            Console.printError(e.getMessage());
        }
        return result;
    }
}
