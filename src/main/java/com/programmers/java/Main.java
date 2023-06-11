package com.programmers.java;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            while(true) {
                System.out.println("1. 조회");
                System.out.println("2. 계산");
                System.out.println();
                System.out.print("선택 : ");
                Scanner sc = new Scanner(System.in);
                String option = sc.nextLine();
                if (option.equals("1")) {
                    try {
                        Calculator.showHistory();
                    } catch (Exception e) {
                        System.out.println("조회 할 데이터가 없습니다.");
                    }
                } else if (option.equals("2")) {
                    String expression = sc.nextLine();
                    if (option.equals("q")) break;
                    try {
                        BigDecimal result = Calculator.calculate(expression);
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("올바르지 않은 수식입니다.");
                        e.printStackTrace();
                    }
                } else if ((option.equals("q"))) {
                    break;
                }
                System.out.println();
            }
    }
}