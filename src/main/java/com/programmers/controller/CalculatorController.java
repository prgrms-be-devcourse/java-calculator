package com.programmers.controller;

import com.programmers.exception.MenuFormatException;
import com.programmers.io.Console;
import com.programmers.service.CalculatorService;
import com.programmers.util.Menu;

public class CalculatorController {

    private Console console;
    private CalculatorService calculatorService;

    public CalculatorController(Console console, CalculatorService calculatorService) {
        this.console = console;
        this.calculatorService = calculatorService;
    }

    private boolean isRunning = true;

    public void run() {
        while (isRunning) {
            try {
                console.getMenu();
                String request = console.getRequest();
                response(request);
            } catch (RuntimeException e) {
                console.printErrorMsg(e.getMessage());
            }
        }
    }

    // 사용자 요청에 응답하기
    private void response(String request) throws RuntimeException {

        //저장된 값 조회
        if (Menu.HISTORY.getNumber().equals(request)) {
            showHistory();

            // 연산
        } else if (Menu.CALCULATE.getNumber().equals(request)) {
            doCalculate();

        } else if (Menu.END.getNumber().equals(request)) {
            // 종료
            stop();

        } else {
            throw new MenuFormatException();
        }

    }

    private void showHistory() {
        console.println(calculatorService.showHistory());
    }

    private void doCalculate() {
        String equation = console.getEquation();
        double answer = calculatorService.calculate(equation);
        console.println(answer);
        calculatorService.save(equation, answer);
    }

    private void stop() {
        isRunning = false;

    }


}
