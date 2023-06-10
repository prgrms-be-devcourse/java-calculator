package com.programmers.engine;

import com.programmers.io.Console;
import com.programmers.repository.CalculatorHistory;
import com.programmers.validator.Validator;

public class Calculator {

    private Console console; //final 설정 시 생성자보다 먼저 초기화가 일어나기 때문
    private PostfixCalculator postfixCalculator;
    private Validator validator;
    private CalculatorHistory calculatorHistory;
    private boolean isRunning = true;

    public Calculator() {
        this.console = new Console();
        this.postfixCalculator = new PostfixCalculator();
        this.validator = new Validator();
        this.calculatorHistory = new CalculatorHistory();
    }


    // 사용자 요청에 응답하기
    private void response(String request) {

        if ("1".equals(request)) {
            //저장된 값 조회
            console.printHistory(calculatorHistory.findAll());

        } else if ("2".equals(request)) {
            // 연산
            String formula = console.input();

            if (validator.checkFormula(formula)) {
                double answer = postfixCalculator.infixToPostfix(formula);
                console.printResult(answer);
                calculatorHistory.save(formula, answer);
            } else {
                // 연산자가 1//2 와 같은 경우는 처리를 못하고 있음
                console.printErrorMessage("올바른 식을 입력해주세요.");
            }

        }else if ("3".equals(request)) {
            // 종료
            isRunning = false;
        } else {
            console.printErrorMessage("선택지에 해당하는 값을 입력해주세요.");
        }
    }

    public void run() {
        while (isRunning) {
            String request = console.initMessage();
            response(request);
        }

    }
}
