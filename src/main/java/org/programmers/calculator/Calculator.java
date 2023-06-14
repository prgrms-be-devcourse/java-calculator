package org.programmers.calculator;

import org.programmers.Io.Console;
import org.programmers.repository.CalRepository;
import org.programmers.validator.Validator;

import java.lang.invoke.WrongMethodTypeException;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Calculator {


    private final Console console;
    private final Validator validator;

    private final ExpressionEvaluator expressionEvaluator;

    private final CalRepository calRepository;

    private final Scanner sc = new Scanner(System.in);

    private boolean isRunning;


    public Calculator(Console console, ExpressionEvaluator expressionEvaluator, CalRepository calRepository) {
        this.console = console;
        this.validator = validator;
        this.expressionEvaluator = expressionEvaluator;
        this.calRepository = calRepository;
    }

    public boolean getRunning() {
        return isRunning;
    }


    public void setRunning(boolean running) {
        isRunning = running;
    }


    boolean isRunning = true;

    public void run() {
        while (isRunning) {
            console.printOption();
            String inputNum = console.inputNum();
            Option option = changeOption(inputNum);
            if (option == null){
                System.out.println("올바른 번호를 입력해주세요. 1 : 조회 , 2 : 계산 , 0 : 종료");
                continue;
            }

            // 분기
            extracted(option);
            // 1. method flow control -> flag, early return
        }
    }

    //문자열을 이넘타입으로 변환하는 메서드
    private Option changeOption(String inputNum) {
        Option option = null;

        try {
            Optional<Option> optionalOption = Option.findByNumber(inputNum);
            option = optionalOption.orElse(null);
        } catch (WrongMethodTypeException e) {
            console.printError(e.getMessage());
        }
        return option;
    }
}
