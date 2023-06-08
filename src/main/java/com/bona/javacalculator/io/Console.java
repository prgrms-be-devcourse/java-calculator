package com.bona.javacalculator.io;

import java.util.Scanner;

public class Console implements Input, Output{

    private static final Scanner scanner = new Scanner(System.in);


    @Override
    public String input(String input) {
        System.out.println(input);
        return scanner.nextLine();
    }

    @Override
    public void inputError() {
        System.out.println("입력을 잘못하셨습니다.");
    }

    @Override
    public void outFormula() {
        System.out.println();
    }

    @Override
    public void outAnswer() {

    }
}
