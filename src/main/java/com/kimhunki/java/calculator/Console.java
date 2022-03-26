package com.kimhunki.java.calculator;

import com.kimhunki.java.calculator.io.Input;
import com.kimhunki.java.calculator.io.Output;

import java.util.Scanner;

public class Console implements Input, Output
{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String s)
    {
        System.out.print(s);
        return scanner.nextLine();
    }

    @Override
    public void inputError()
    {
        System.out.println("입력이 잘못되었습니다.");
    }

    @Override
    public void output(String s)
    {
        System.out.println(s);
    }

    //    @Override
//    public String result(String expression)
//    {
//
//    }
}
