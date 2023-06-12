package org.programmers.calculator;

import org.programmers.Io.Console;
import org.programmers.validator.Validator;

import java.lang.invoke.WrongMethodTypeException;
import java.util.Scanner;

public class Calculator {


    private final Console console;
    private final Validator validator;

    private final ExpressionEvaluator expressionEvaluator;

    private final Scanner sc = new Scanner(System.in);



    public Calculator(Console console, ExpressionEvaluator expressionEvaluator) {
        this.console = console;
        this.validator = new Validator(console);
        this.expressionEvaluator = expressionEvaluator;
    }


    boolean isRunning = true;

    public void run() {
        while (isRunning) {
            console.printOption();
            String inputNum = console.inputNum();
            Option option = ChangeOption(inputNum);
            System.out.println("option = " + option);
            if (option == null)
                continue;

            switch (option) {
                case QUERY:
                    System.out.println("console.printQuery();");
                    break;
                case CALC:
                   // String formula = console.inputFormula();
                   // System.out.println("formula = " + formula); console.inputFormula()로 입력이 안됨 추후 리팩토링
                    String formula = sc.nextLine();
                    String result = expressionEvaluator.requestCalculate(formula);
                    console.printCal(result);
                    break;
                case EXIT:
                    isRunning = false;
                    System.out.println("계산기 종료");
                    break;
            }

        }
    }

    //문자열을 이넘타입으로 변환하는 메서드
    private Option ChangeOption(String inputNum) {
        Option option = null;

        try {
            option = Option.findByNumber(inputNum);
        } catch (WrongMethodTypeException e) {
            console.printError(e.getMessage());
        }
        return option;
    }
}
