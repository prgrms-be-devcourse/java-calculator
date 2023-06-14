package com.programmers.view;

import com.programmers.util.Validator;

import java.util.Scanner;

/**
 * 입력
 */

public class Input {
    private static final String NOTINTEGERMESSAGE = "\n정수가 아닙니다. 메뉴를 다시 입력해주세요\n선택 : ";
    private static final String NOTMENUMESSAGE = "없는 메뉴 입니다. 메뉴를 다시 입력해주세요\n선택 : ";
    private static final String NOTVALIDARITHMETICEXPRESSION = "계산식이 옳지 않습니다. 식을 다시 입력해주세요\n";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMenu() {
        int menuNum;

        try {
            String menuString = Validator.removeWhiteSpace(scanner.nextLine());
            menuNum = Validator.checkInteger(menuString);
        } catch (NumberFormatException e) {
            System.out.print(NOTINTEGERMESSAGE);
            return inputMenu(); //반복
        }

        System.out.println(); //공백

        if (!Validator.checkValidMenu(menuNum)) {
            System.out.print(NOTMENUMESSAGE);
            inputMenu(); //반복
        }

        return menuNum;
    }

    public static String inputExpression() {
        String expression = scanner.nextLine();

        //공백 제거
        expression = Validator.removeWhiteSpace(expression);

        //사칙연산(+,-,*,/)과 숫자만으로 구성되어 있는지 확인
        if (!Validator.checkValidArithmeticExpression(expression)) {
            System.out.print(NOTVALIDARITHMETICEXPRESSION);
            inputExpression(); //반복
        }

        return expression;
    }
}
