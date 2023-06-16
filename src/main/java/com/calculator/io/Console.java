package com.calculator.io;

import java.util.Scanner;

public class Console implements Input, Output{

    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void printMenu() {
        System.out.print("\n1. 조회\n2. 계산\n3. 종료\n\n선택: ");
    }

    @Override
    public String getMenuOption() {
        String menuOption = scanner.nextLine();

        return menuOption;
    }

    @Override
    public String getExpression(){
        String expression = scanner.nextLine();
        return expression;
    }
}
