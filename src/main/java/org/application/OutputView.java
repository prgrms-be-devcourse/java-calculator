package org.application;

import org.domain.model.Calculator;

public class OutputView {

    public static void outputByMenu() {

        StringBuilder menu = new StringBuilder();

        menu.append("1. 조회").append("\n");
        menu.append("2. 계산").append("\n");
        menu.append("3. 종료").append("\n");
        menu.append("\n").append("입력 : ");

        System.out.print(menu);
    }

    public static void exitCalculator() {

        System.out.print("\n계산기를 종료합니다.");
    }
}
