package io;

import model.Expression;
import repository.ResultRepository;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String showOption() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.print("선택 : ");
        String userInput = scanner.nextLine();
        System.out.println();
        return userInput;
    }

    @Override
    public String inputForCalculate() {
        return scanner.nextLine();
    }

    @Override
    public void showHistory(List<Expression> list) {
        for (Expression expression : list) {
            System.out.println(expression.getExpressionWithResult());
        }
    }
}
