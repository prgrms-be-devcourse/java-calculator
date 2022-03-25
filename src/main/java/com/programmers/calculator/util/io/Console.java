package com.programmers.calculator.util.io;

import com.programmers.calculator.exception.NumberInputException;
import com.programmers.calculator.vo.Formula;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output<Formula> {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int inputNumber(String script) throws NumberInputException {
        System.out.print(script);
        String str = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberInputException();
        }
        return number;
    }

    @Override
    public String inputString(String script) {
        System.out.print(script);
        return scanner.nextLine();
    }

    @Override
    public void outputList(List<Formula> list) {
        list.forEach(System.out::println);
    }
}
