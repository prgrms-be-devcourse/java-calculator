package com.programmers.calculator.io;

import com.programmers.calculator.domain.Expression;
import com.programmers.calculator.domain.Menu;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Menu selectMenu() {
        System.out.print("\n선택: ");
        String menuNumber = scanner.nextLine();

        return Menu.findByNumber(menuNumber);
    }

    @Override
    public Expression readExpression() {
        return new Expression(scanner.nextLine());
    }
}
