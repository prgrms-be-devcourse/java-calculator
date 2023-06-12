package com.programmers.engine;

import com.programmers.io.Console;
import com.programmers.repository.CalculatorHistory;


public class Calculator {

    private Console console;
    private PostfixCalculator postfixCalculator;
    private CalculatorHistory calculatorHistory;

    public Calculator(Console console, PostfixCalculator postfixCalculator, CalculatorHistory calculatorHistory) {
        this.console = console;
        this.postfixCalculator = postfixCalculator;
        this.calculatorHistory = calculatorHistory;
    }

    private boolean isRunning = true;
    private static String HISTORY = "1";
    private static String CALC = "2";
    private static String END = "3";


    // 사용자 요청에 응답하기
    private void response(String request) throws RuntimeException {

        //저장된 값 조회
        if (HISTORY.equals(request)) {
            console.println(calculatorHistory.findAll());

            // 연산
        } else if (CALC.equals(request)) {
            String equation = " ";
                equation = console.getEquation();
            double answer = postfixCalculator.infixToPostfix(equation);
            console.println(answer);
            calculatorHistory.save(equation, answer);

        } else if (END.equals(request)) {
            // 종료
            isRunning = false;
        }

    }

    public void run() {
        while (isRunning) {
            String request = "";
            try {
                request = console.getMenu();
                response(request);
            } catch (RuntimeException e) {
                console.printErrorMsg(e.getMessage());
            }
        }
    }

}
