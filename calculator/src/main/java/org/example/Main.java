package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static int choice;
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterfaceImpl();
        Type type = new UserType();
        CalOrder calculator = new Calculate();

        while (true) {
            choice = getChoice();
            System.out.println();
            if (choice == 1) {
                userInterface.showRecord();
            } else {
                String expression = type.typeExpression();
                calculator.getExpression(expression);
                calculator.calculate();
            }
            System.out.println();
        }
    }

        System.out.println("1. 조회\n2. 계산\n");
        System.out.print("선택 : ");
}
