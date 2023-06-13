package com.programmers.io;

import com.programmers.domain.Expression;
import com.programmers.domain.Menu;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Menu selectMenu() {
        System.out.print("선택: ");
        String menuNumber = scanner.nextLine();

        return Menu.findByNumber(menuNumber);
    }

    @Override
    public Expression readExpression() {
        return new Expression(scanner.nextLine());
    }
}
