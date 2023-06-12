package io;

import model.vo.Expression;
import model.vo.Menu;

import java.util.Scanner;

public class CalculatorScannerInput implements CalculatorInput {
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public Menu menuInput() {
        return new Menu(sc.nextLine());
    }

    @Override
    public Expression expressionInput() {
        return new Expression(sc.nextLine());
    }
}
