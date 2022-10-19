package me.programmers.calculator.engine.io;

import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner sc = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    @Override
    public String problemInput() {
        return sc.nextLine().replaceAll(" ", "");
    }

    @Override
    public void output(String s) {
        System.out.println(s);
    }

}
