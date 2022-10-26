package com.programmers;

import com.programmers.engine.io.*;
import com.programmers.engine.model.DataBase;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void showAll(DataBase db) {
        db.showAll();
    }

    @Override
    public void inputError() {System.out.println("Input Error");}

    @Override
    public void bye() {System.out.println("안녕~");}


    @Override
    public void wrongChoice() {
        System.out.println("Wrong choice please input 1 number");
    }

    @Override
    public void numOperatorValidationError() {
        System.out.println("Validation Error : check numbers or operators");
    }

    @Override
    public void bracketValidationError() {
        System.out.println("Validation Error : check brackets");
    }
}
