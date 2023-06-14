package org.programmers.Io;

import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output{
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void printOption() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("0. 종료");
    }

    @Override
    public String inputNum() {
        System.out.print("선택: ");
        return sc.next();
    }

    @Override
    public void printExit(){
        System.out.println("계산기가 종료되었습니다.");
    }

    @Override
    public String inputFormula() {
        return sc.nextLine();
    }

    @Override
    public void printError(String errorMsg) {
        System.out.println(errorMsg);
    }

    @Override
    public void printCal(String result) {
        System.out.println(result);

    }

    @Override
    public void printQuery(Map<Long, String> query) {
        for (Long key : query.keySet()) {
            String result = query.get(key);
            System.out.println(result);
        }

    }
}
