package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choice = 0;

        while (true) {
            choice = getChoice();
            System.out.println();
            if (choice == 1) {
                new UserInterfaceImpl().showRecord();
            } else {
                String expression = typeExpression();
                new Calculate(expression).calculate();
            }
            System.out.println();
        }
    }

    public static int getChoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. 조회\n2. 계산\n");
        System.out.print("선택 : ");
        return scanner.nextInt();
    }

    public static String typeExpression() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
