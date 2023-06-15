package com.programmers.calculator;

import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;
import com.programmers.calculator.model.Expression;

import java.util.List;
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
    public void printMenu(List<String> menu) {
        menu.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printResult(int result) {
        System.out.println(result + "\n");
    }
}
