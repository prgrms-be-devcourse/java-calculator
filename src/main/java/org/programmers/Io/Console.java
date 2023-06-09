package org.programmers.Io;

import java.util.List;
import java.util.Scanner;

public class Console {
    private final Scanner sc = new Scanner(System.in);

    public void printOption() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("0. 종료");
    }

    public String inputNum() {
        System.out.print("선택: ");
        return sc.next();
    }

    public void printError(String errorMsg) {
        System.out.println("errorMsg = " + errorMsg);
    }

    public void printCal(String result) {
        System.out.println(result);

    }

    public void printQuery(List<String> query) {
        for (String s : query) {
            System.out.println(s);
        }

    }


}
