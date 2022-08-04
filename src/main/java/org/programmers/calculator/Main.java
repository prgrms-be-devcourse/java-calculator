package org.programmers.calculator;

import org.programmers.calculator.configuration.Config;
import org.programmers.calculator.configuration.ObjectContainer;
import org.programmers.calculator.configuration.Operand;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Config config = new Config();
        init(config);
        Menu menu = ObjectContainer.getMenu();
        try {
            menu.run(config);
        } catch (InputMismatchException e) {
            System.out.println("입력이 부적합합니다. 메뉴로 돌아갑니다.");
            menu.run(config);
        }
    }

    private static void init(Config config) {
        config.set(Operand.RATIONAL_NUMBER);
    }
}
