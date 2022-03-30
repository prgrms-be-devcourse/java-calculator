package com.programmers.java;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String chooseOpt(String messsage) {
        System.out.println(messsage);
        return scanner.nextLine();
    }

    @Override
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public void output(String s) {
        System.out.println(s);
    }

    @Override
    public void inputError() {
        System.out.println("범위 안에서 선택해주세요");

    }

    @Override
    public void error(String msg) {
        System.out.println(msg);
    }

}
