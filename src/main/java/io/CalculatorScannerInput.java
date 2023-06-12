package io;

import model.ExpressionVO;
import model.MenuVO;

import java.util.Scanner;

public class CalculatorScannerInput implements CalculatorInput {
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public MenuVO menuInput() {
        return new MenuVO(sc.nextLine());
    }

    @Override
    public ExpressionVO expressionInput() {
        return new ExpressionVO(sc.nextLine());
    }
}
