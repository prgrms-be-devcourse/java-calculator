package org.example;

import org.example.Input.Input;
import org.example.Input.UserInput;
import org.example.Output.Show;
import org.example.Output.ShowText;
import org.example.Repository.ExpressionRepository;
import org.example.Repository.Repository;

import java.util.List;

public class Main {
    private static int choice;
    public static void main(String[] args) {
        Repository repository = new ExpressionRepository();
        Input input = new UserInput();
        CalOrder calculator = new Calculate();
        Show show = new ShowText();

        while (true) {
            show.showMenu();
            choice = input.inputChoice();
            System.out.println();
            if (choice == 1) {
                List<String> records = repository.getRecords();
                show.showRecords(records);
            } else {
                String expression = input.inputExpression();
                calculator.getExpression(expression);
                calculator.calculate();
            }
            System.out.println();
        }
    }
}
