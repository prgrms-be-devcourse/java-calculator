package com.programmers.controller;

import com.programmers.io.Console;
import com.programmers.model.UserEquation;
import com.programmers.service.CalculatorService;
import com.programmers.util.Menu;
import com.programmers.model.UserRequest;

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
                UserRequest userRequest = new UserRequest(console.getRequest());
                response(userRequest);
            } catch (RuntimeException e) {
                console.printErrorMsg(e.getMessage());
            }
        }
    }

    // 사용자 요청에 응답하기
    // 새로운 객체로 감싸기 (Request)
    // 형변환에 대한 자유
    private void response(UserRequest userRequest) throws RuntimeException {
        Menu menu = Menu.getMenu(userRequest);

        if (menu == Menu.HISTORY) {
            showHistory();
        }

        if (menu == Menu.CALCULATE) {
            executeCalculate();
        }

        if (menu == Menu.END) {
            stop();
        }
    }

    private void showHistory() {
        console.printResult(calculatorService.showHistory());
    }

    private void executeCalculate() {
        UserEquation equation = console.getEquation();
        double answer = calculatorService.calculate(equation);
        calculatorService.save(equation.getEquation(), answer);
        console.println(answer);
    }

    private void stop() {
        isRunning = false;

    }


}
