package com.programmers.calculator;

import com.programmers.converter.ExpressionConverter;
import com.programmers.exception.WrongInputExpressionException;
import com.programmers.exception.WrongInputMenuException;
import com.programmers.io.Console;

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
            MenuType menu = makeMenuType(Console.inputMenuNumber());

            if (menu == null)
                continue;

            switch (menu) {
                case HISTORY:
                    Console.printHistory(memory.findAll());
                    break;

                case CALCULATE:
                    String expression = Console.inputExpression();
                    String result = calculate(expression);
                    if (result == null)
                        break;
                    memory.save(new CalcResult(expression, result));
                    Console.printResult(result);
                    break;

                case EXIT:
                    power = false;
                    Console.printExit();
                    break;
            }
        }
    }

    private MenuType makeMenuType(String inputMenuNumber) {
        MenuType menu = null;
        try {
            menu = MenuType.findMenuType(inputMenuNumber);
        } catch (WrongInputMenuException e) {
            Console.printError(e.getMessage());
        }
        return menu;
    }

    private String calculate(String expression) {
        String result = null;
        try {
            result = accumulator.compute(expression);
        } catch (WrongInputExpressionException | ArithmeticException e) {
            Console.printError(e.getMessage());
        }
        return result;
    }
}
