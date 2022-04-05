package com.programmers.java.calculator.io;

import java.util.List;

public class ConsoleOutput implements Output{

    @Override
    public void printInputError() {
        System.out.println("잘못된 입력입니다.");
    }

    @Override
    public void printMenu() {
        System.out.println("\n1. 조회\n2. 계산\n");
    }

    @Override
    public void printLogs(List<String> log) {
        log.forEach(System.out::println);
    }


    public void print(String res){
        System.out.println(res);
    }

    @Override
    public void printCloseConsole() {
        System.out.println("프로그램을 종료합니다.");
    }

    @Override
    public void printRuntimeError() {
        System.out.println("Runtime Error!");
    }
}
