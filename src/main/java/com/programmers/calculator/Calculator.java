package com.programmers.calculator;

import java.util.Scanner;

public class Calculator {
    void play() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. 조회\n2. 계산\n3. 종료\n");
            System.out.print("선택: ");

            String s = sc.nextLine();
            System.out.println();
            boolean close = false;
            switch(s) {
                case "1" :
                    System.out.println("조회");
                    break;
                case "2" :
                    System.out.println("계산");
                    break;
                case "3" :
                    close = true;
                    break;
                default :
                    System.out.println("잘못된 입력");
                    break;
            }

            if(close) break;
            System.out.println();
        }

        sc.close();
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int multiply(int a, int b, int c) {
        return a * b * c;
    }
}
