package calculator;

import calculator.engine.io.Input;
import calculator.engine.io.Output;

import java.util.ArrayList;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public void calcResult(double result) {
        System.out.println(String.format("%.3f", result));
    }

    @Override
    public void calcHistory(ArrayList<String> histories) {
        for (String s : histories) {
            System.out.println(s);
        }
    }
}
