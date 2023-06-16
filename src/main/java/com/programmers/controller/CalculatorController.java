package com.programmers.controller;

import com.programmers.exception.MenuFormatException;
import com.programmers.io.Console;
import com.programmers.service.CalculatorService;
import com.programmers.util.Menu;
import com.programmers.util.Request;

public class CalculatorController {

    private final Console console;
    private final CalculatorService calculatorService;
    private boolean isRunning = true;

    public CalculatorController(Console console, CalculatorService calculatorService) {
        this.console = console;
        this.calculatorService = calculatorService;
    }

    public void run() {
        while (isRunning) {
            try {
                console.getMenu();
                Request request = new Request(console.getRequest());
                response(request);
            } catch (RuntimeException e) {
                console.printErrorMsg(e.getMessage());
            }
        }
    }

    // 사용자 요청에 응답하기
    // 새로운 객체로 감싸기 (Request)
    // 형변환에 대한 자유
    private void response(Request request) throws RuntimeException {
        Menu menu = Menu.getMenu(request);

        //저장된 값 조회
        if (menu == Menu.HISTORY) {
            showHistory();

            // 연산
        } else if (menu == Menu.CALCULATE) {
            doCalculate();

            // 종료
        } else {
            stop();
        }
    }

    private void showHistory() {
        console.printResult(calculatorService.showHistory());
    }

    private void doCalculate() {
        String equation = console.getEquation();
        double answer = calculatorService.calculate(equation);
        calculatorService.save(equation, answer);
        console.println(answer);
    }

    private void stop() {
        isRunning = false;

    }


}
