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

    private final Calculate calculate;

    private final CalRepository calRepository;

    private final Scanner sc = new Scanner(System.in);

    private boolean isRunning;

    public Calculator(Console console, Calculate calculate, CalRepository calRepository, Validator validator) {
        this.console = console;
        this.validator = validator;
        this.calculate = calculate;
        this.calRepository = calRepository;
    }

    public boolean getRunning() {
        return isRunning;
    }


    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void run() {

        isRunning = true;


        while (getRunning()) {
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

    private void extracted(Option option) {
        switch (option) {
            case QUERY:
                Map<Long, String> queryList = calRepository.getQueryList();
                console.printQuery(queryList);
                break;
            case CALC:
                String formula = console.inputFormula();
                // 입력된 연산식의 유효성 검증
                if (!validator.validateCalculation(formula)) {
                    break;
                }
                String result = calculate.requestCalculate(formula);
                console.printCal(result);
                calRepository.save(formula, result);
                break;
            case EXIT:
                console.printExit();
                setRunning(false);
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
