package com.programmers.java.io;

import com.programmers.java.data.Result;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public String input() {
        return sc.nextLine();
    }

    @Override
    public int select(String s) {
        System.out.println(s);
        String select = sc.nextLine();
        if(select.equals("1") || select.equals("2")){
            return Integer.parseInt(select);
        }else{
            return -1;
        }
    }

    @Override
    public void output(Result res) {
        System.out.println(res.getExp() + "= " + res.getAnswer() + "\n");
    }

    @Override
    public void error() {
        System.out.println("잘못된 입력입니다.");
    }

    @Override
    public void outputAnswer(Result calculate) {
        System.out.println(calculate.getAnswer() + "\n");
    }
}
