package com.programmers.view;

import com.programmers.domain.Formula;

import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void selectMenuView() {
        System.out.print("1. 조회 " + System.lineSeparator()
                + "2. 계산" + System.lineSeparator()
                + "3. 종료 " + System.lineSeparator() + System.lineSeparator()
                + "선택 : ");
    }

    public static void calculateResult(int result) {
        System.out.println(result + System.lineSeparator());
    }

    public static void inquire(Map<Integer, Formula> results) {
        for (Map.Entry<Integer, Formula> entry : results.entrySet()) {
            Formula formula = entry.getValue();
            System.out.println(formula.getFormula());
        }
    }
}
