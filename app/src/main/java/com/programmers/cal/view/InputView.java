package com.programmers.cal.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String PREPARE = "1. 조회\n2. 계산\n3. 그만하기\n선택 : ";

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 4;
    private static final String INVALID_DIVISION_ZERO = " / 0";
    private static final String NUMBER_ERROR_MESSAGE = "선택은 1~3으로 선택해 주세요";
    private static final String FORMULA_ERROR_MESSAGE = "수식이 올바르지 않습니다.";

    private static final Scanner SC = new Scanner(System.in);

    public static int preparation() {
        System.out.print(PREPARE);
        String selected = SC.nextLine();
        typeValidator(selected);
        selectValidator(Integer.parseInt(selected));

        return Integer.parseInt(selected);
    }

    public static String inputTheFormula() {
        String formula = SC.nextLine();
        if (formulaValidator(formula) && zeroDivisionValidator(formula)) {
            return formula;
        }

        throw new IllegalArgumentException(FORMULA_ERROR_MESSAGE);
    }

    private static void typeValidator(String selected) {
        try {
            Integer.parseInt(selected);
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }

    private static void selectValidator(int number) {
        if (!(number > MIN_NUMBER && number < MAX_NUMBER)) {
            new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static boolean formulaValidator(String formula) {
        boolean check = Pattern.matches(".*\\d$", formula);
        if (check) return true;

        return false;
    }

    private static boolean zeroDivisionValidator(String formula) {
        return !formula.contains(INVALID_DIVISION_ZERO);
    }

}
