package com.programmers;

import com.programmers.engine.io.*;
import com.programmers.engine.model.DataBase;

import java.util.LinkedList;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void showAll(LinkedList<String> l) {
        l.forEach(System.out::println);
    }

    @Override
    public void inputError() {System.out.println("Input Error");}

    @Override
    public void bye() {System.out.println("안녕~");}


    @Override
    public void wrongChoice() {
        System.out.println("Wrong choice please choose in 1, 2 or 3");
    }

    @Override
    public void numOperatorValidationError() {
        System.out.println("Validation Error : check numbers or operators");
    }

    @Override
    public void bracketValidationError() {
        System.out.println("Validation Error : check brackets");
    }

    @Override
    public void caution() {
        System.out.println("아직 완벽하지 않은 계산기입니다\n 계산식을 입력할 때, 수와 연산자는 공백으로 분리해서 입력해주세요!");
    }

    @Override
    public void divdeByZeroError() {
        System.out.println("Divided By Zero Error!!");
    }

    @Override
    public void dbNoDate() {
        System.out.println("저장된 데이터가 없습니다");
    }

    @Override
    public void simplePrint(String s) {
        System.out.println(s);
    }
}
