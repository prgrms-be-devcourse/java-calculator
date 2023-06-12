package com.programmers.controller;

import com.programmers.engine.PostfixCalculator;
import com.programmers.io.Console;
import com.programmers.repository.CalculatorHistory;

public class CalculatorController {

    private Console console;
    private PostfixCalculator postfixCalculator;
    private CalculatorHistory calculatorHistory;

    public CalculatorController(Console console, PostfixCalculator postfixCalculator, CalculatorHistory calculatorHistory) {
        this.console = console;
        this.postfixCalculator = postfixCalculator;
        this.calculatorHistory = calculatorHistory;
    }

    private boolean isRunning = true;
    private static String HISTORY = "1";
    private static String CALC = "2";
    private static String END = "3";

    public void run() {
        while (isRunning) {
            try {
                String request = console.getMenu();
                response(request);
            } catch (RuntimeException e) {
                console.printErrorMsg(e.getMessage());
            }
        }
    }

    // 사용자 요청에 응답하기
    private void response(String request) throws RuntimeException {

        //저장된 값 조회
        if (HISTORY.equals(request)) {
            showHistory();

            // 연산
        } else if (CALC.equals(request)) {
            calculate();

        } else if (END.equals(request)) {
            // 종료
            stop();

        } else {
            throw new RuntimeException();
        }

    }

    private void showHistory() {
        console.println(calculatorHistory.findAll());
    }

    private void calculate() {
        String equation = console.getEquation();
        double answer = postfixCalculator.infixToPostfix(equation);
        console.println(answer);
        calculatorHistory.save(equation, answer);
    }

    private void stop() {
        isRunning = false;

    }


}
