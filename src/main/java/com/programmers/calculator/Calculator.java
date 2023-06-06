package com.programmers.calculator;

import com.programmers.converter.ExpressionConverter;
import com.programmers.converter.InfixToPostfixConverter;
import com.programmers.exception.WrongInputExpressionException;
import com.programmers.exception.WrongInputMenuException;
import com.programmers.io.Console;

import java.util.Collections;
import java.util.List;

public class Calculator {
    ExpressionConverter expressionConverter;
    boolean power = true;

    public Calculator() {
        expressionConverter = new InfixToPostfixConverter();
    }

    public void run() {
        while(power) {
            Console.printMenu();
            MenuType menu = makeMenuType(Console.inputMenuNumber());

            if(menu == null)
                continue;

            switch(menu){
                case CALCULATE:
                    String expression = Console.inputExpression();
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
}
