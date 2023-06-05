package org.console;

import org.domain.model.Calculator;

public class OutputView {

    public static void outputByMenu() {

        StringBuilder menu = new StringBuilder();

        menu.append("1. 조회").append("\n");
        menu.append("2. 계산").append("\n");
        menu.append("3. 종료").append("\n");
        menu.append("\n").append("입력 : ");

        System.out.println(menu);
    }

    public static void printCalculator(Calculator calculator) {

        StringBuilder formula = new StringBuilder();

        formula.append("\n");
        formula.append(calculator.getOperation());
        formula.append(" = ");
        formula.append(calculator.getAnswer()).append("\n");

        System.out.println(formula);
    }

    public static void exitCalculator() {

        System.out.println("\n계산기를 종료합니다.");
    }
}
