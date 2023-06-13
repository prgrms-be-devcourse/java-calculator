package com.programmers.calculator;

import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;
import com.programmers.calculator.model.Expression;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String inputMenu(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public Expression inputExpression() {

        String expression = scanner.nextLine();
        return new Expression(expression);
    }

    @Override
    public void printMenu(String menu) {
        System.out.println(menu);
    }
}
