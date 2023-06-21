package com.programmers.view;

import com.programmers.error.CalculatorException;
import com.programmers.util.Validator;

import java.util.Scanner;

import static com.programmers.error.ConsoleMessage.INPUT_RETRY_MESSAGE;

/**
 * 입력
 */

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public static int processMenu(String menuString) {

        menuString = removeWhiteSpace(menuString);
        int menuNum = Validator.validateMenu(menuString);

        return menuNum;
    }

    public static String inputLine() {
        return scanner.nextLine();
    }

    public static String processExpression(String beforeProcessExpression) {

        String removeWhiteSpaceExpression = removeWhiteSpace(beforeProcessExpression);
        Validator.checkValidArithmeticExpression(removeWhiteSpaceExpression);

        return beforeProcessExpression;
    }


    //공백 제거
    public static String removeWhiteSpace(String input) {
        return input.replaceAll("\\s+", "");
    }

}
