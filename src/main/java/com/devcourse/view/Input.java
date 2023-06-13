package com.devcourse.view;

import com.devcourse.valid.FormulaValidator;
import com.devcourse.valid.MenuValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private Input() {
    }

    public static int selectMenu() {
        String menuNumber = getUserInput();
        if (MenuValidator.valid(menuNumber)) {
            return Integer.parseInt(menuNumber);
        }
        throw new RuntimeException("1, 2 두개의 메뉴 중 하나를 입력해 주세요");
    }

    public static String getFormula() {
        String formula = getUserInput();
        if (FormulaValidator.valid(formula)) {
            return formula;
        }
        throw new RuntimeException("잘못된 식 양식입니다 (ex : 1 + 2 / 3)");
    }

    private static String getUserInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
