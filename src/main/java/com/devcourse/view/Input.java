package com.devcourse.view;

import com.devcourse.valid.FormulaValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private Input() {
    }

    public static int selectMenu() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException();
        } catch (NumberFormatException e) {
            throw new RuntimeException("메뉴 선택시 숫자를 입력해 주세요");
        }
    }

    public static String getFormula() {
        try {
            String formula = reader.readLine();
            if (FormulaValidator.valid(formula)) {
                return formula;
            }
            throw new RuntimeException("잘못된 식 양식입니다 (ex : 1 + 2 / 3)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
