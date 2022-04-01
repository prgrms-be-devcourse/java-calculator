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

    @Override
    public void menuOutput()
    {
        System.out.println("1. 조회\n2. 계산\n3. 종료\n\n");
    }

    @Override
    public void emptyRepository()
    {
        System.out.println("아무 결과도 찾을 수 없습니다.");
    }

    @Override
    public void end()
    {
        System.out.println("계산기를 종료합니다.");
    }

    @Override
    public void divError()
    {
        System.out.println("0으로 나눌 수 없습니다.");
    }
}
