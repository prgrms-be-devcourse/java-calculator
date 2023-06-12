package org.programmers.calculator;

import org.programmers.Io.Console;
import org.programmers.repository.CalRepository;
import org.programmers.validator.Validator;

import java.lang.invoke.WrongMethodTypeException;
import java.util.Map;
import java.util.Scanner;

public class Calculator {


    private final Console console;
    private final Validator validator;

    private final ExpressionEvaluator expressionEvaluator;

    private final CalRepository calRepository;

    private final Scanner sc = new Scanner(System.in);


    public Calculator(Console console, ExpressionEvaluator expressionEvaluator, CalRepository calRepository) {
        this.console = console;
        this.validator = new Validator(console);
        this.expressionEvaluator = expressionEvaluator;
        this.calRepository = calRepository;
    }


    boolean isRunning = true;

    public void run() {
        while (isRunning) {
            console.printOption();
            String inputNum = console.inputNum();
            Option option = ChangeOption(inputNum);
            if (option == null){
                System.out.println("올바른 번호를 입력해주세요. 1 : 조회 , 2 : 계산 , 0 : 종료");
                continue;
            }


            switch (option) {
                case QUERY:
                    Map<Long, String> queryList = calRepository.getQueryList();
                    console.printQuery(queryList);
                    break;
                case CALC:
                    // String formula = console.inputFormula();
                    // System.out.println("formula = " + formula); console.inputFormula()로 입력이 안됨 추후 리팩토링

                    String formula = sc.nextLine();
                    // 입력된 연산식의 유효성 검증
                    if (!validator.validateCalculation(formula)) {
                        break;
                    }
                    String result = expressionEvaluator.requestCalculate(formula);
                    console.printCal(result);
                    calRepository.save(formula, result);
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
