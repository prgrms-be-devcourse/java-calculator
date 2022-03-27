package com.programmers.java.calculator.io;

import java.util.List;

public class ConsoleOutput implements Output{

    @Override
    public void inputError() {
        System.out.println("잘못된 입력입니다.");
    }

    @Override
    public void menu() {
        System.out.println("\n1. 조회\n2. 계산\n");
    }

    @Override
    public void logs(List<String> log) {
        log.forEach(System.out::println);
    }

    public void print(String res){
        System.out.println(res);
    }
}
