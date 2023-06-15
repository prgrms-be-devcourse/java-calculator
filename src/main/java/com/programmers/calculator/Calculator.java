package com.programmers.calculator;

import com.programmers.converter.ExpressionConverter;
import com.programmers.io.Console;

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

            MenuType menu = MenuType.findMenuType(Console.inputMenuNumber());

            switch (menu) {
                case HISTORY:
                    String history = inMemory.findAll();
                    Console.printHistory(history);
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
                    Console.printError("메뉴는 1, 2, 3 만 가능합니다.");
                    break;
            }
        }
    }
}
