package com.programmers.java.calculator.engine.io;

import java.util.Scanner;


public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    /**  Output   **/
    @Override
    public void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.print("선택 : ");
    }

    @Override
    public void printError(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printExceptionMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printAnswer(double answer) {
        System.out.println(answer);
    }


    /**  Input   **/
    @Override
    public int inputNum() {
        return scanner.nextInt();
    }

    @Override
    public String inputExpression() {
        return scanner.nextLine();
    }

    @Override
    public String inputBuffer() { // 버퍼비우기
        return scanner.nextLine();
    }


}