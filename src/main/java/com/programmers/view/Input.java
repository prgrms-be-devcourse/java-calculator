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

    public static int inputMenu() {
        int menuNum = 0;
        boolean inputSuccessful = false;

        while(!inputSuccessful){
            try {
                String menuString = removeWhiteSpace(scanner.nextLine());
                menuNum = Validator.validateMenu(menuString);
                inputSuccessful = true;
            } catch (CalculatorException e) {
                Output.printMessage(INPUT_RETRY_MESSAGE);
            }
        }

        Output.printNewLine();//공백

        return menuNum;
    }

    public static String inputExpression() {
        String expression="";
        boolean inputSuccessful = false;

        while(!inputSuccessful){
            try{
                expression = scanner.nextLine();
                expression = removeWhiteSpace(expression);
                Validator.checkValidArithmeticExpression(expression);
                inputSuccessful = true;
            }
            catch (CalculatorException e){
                Output.printMessage(INPUT_RETRY_MESSAGE);
            }
        }

        return expression;
    }


    //공백 제거
    public static String removeWhiteSpace(String input) {
        return input.replaceAll("\\s+", "");
    }

}
