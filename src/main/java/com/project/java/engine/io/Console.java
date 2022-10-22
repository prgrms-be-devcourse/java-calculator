package com.project.java.engine.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements Input, Output{
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final String MENU = "1.조회\n2.계산";

    @Override
    public String getInput(String greeting) throws IOException {
        printMenu();
        System.out.print(greeting);
        return br.readLine();
    }

    @Override
    public void outputResult(String str) {
        System.out.println(str);
    }

    @Override
    public void printMenu() {
        System.out.println(MENU);
    }

    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.");
    }
}
