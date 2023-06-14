package org.example;

import org.example.Input.Type;
import org.example.Input.UserType;
import org.example.Output.Show;
import org.example.Output.ShowText;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static int choice;
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterfaceImpl();
        Type type = new UserType();
        CalOrder calculator = new Calculate();
        Show show = new ShowText();

        while (true) {
            show.showMenu();
            choice = type.typeChoice();
            System.out.println();
            if (choice == 1) {
                userInterface.showRecords();
            } else {
                String expression = type.typeExpression();
                calculator.getExpression(expression);
                calculator.calculate();
            }
            System.out.println();
        }
    }
}
