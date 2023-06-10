package com.programmers.engine;

import com.programmers.exception.EquationFormatException;
import com.programmers.exception.MenuFormatException;
import com.programmers.io.Console;
import com.programmers.io.Input;
import com.programmers.io.Output;
import com.programmers.repository.CalculatorHistory;
import com.programmers.validator.InputValidator;


public class Calculator {

    private Input input; //final 설정 시 생성자보다 먼저 초기화가 일어나기 때문
    private Output output; //final 설정 시 생성자보다 먼저 초기화가 일어나기 때문
    private PostfixCalculator postfixCalculator;
    private CalculatorHistory calculatorHistory;

    public Calculator(Input input, Output output, PostfixCalculator postfixCalculator, CalculatorHistory calculatorHistory) {
        this.input = input;
        this.output = output;
        this.postfixCalculator = postfixCalculator;
        this.calculatorHistory = calculatorHistory;
    }

    private boolean isRunning = true;
    private static String HISTORY = "1";
    private static String CALC = "2";
    private static String END = "3";


    // 사용자 요청에 응답하기
    private void response(String request) {

        //저장된 값 조회
        if (HISTORY.equals(request)) {
            output.println(calculatorHistory.findAll());

            // 연산
        } else if (CALC.equals(request)) {
            String equation = " ";
            try {
                equation = input.getEquation();
            } catch (EquationFormatException efe) {
                output.printErrorMsg(efe.getMessage());
                return;
            }
            double answer = postfixCalculator.infixToPostfix(equation);
            output.println(answer);
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
                request = input.getMenu();
            } catch (MenuFormatException mfe) {
                output.printErrorMsg(mfe.getMessage());
            }
            response(request);
        }
    }

}
