package com.programmers.blackdog.controller;

import com.programmers.blackdog.controller.constant.Selection;
import com.programmers.blackdog.service.CalculatorService;
import com.programmers.blackdog.service.Service;
import com.programmers.blackdog.view.Console;

import java.util.List;

import static com.programmers.blackdog.controller.constant.Selection.findByCode;

public class CalculatorController {

    private final Service service;
    private final Console console;

    public CalculatorController(Console console) {
        this.console = console;
        this.service = new CalculatorService();
    }

    public void run() {
        while (true) {
            try {
                switch (getCode()) {
                    case CHECK_DATA:
                        printAllPreviousData();
                        break;
                    case CALCULATE:
                        printCalculatedResultAndSave();
                        break;
                    case EXIT:
                        exitProgram();
                        return;
                }
            } catch (Exception e) {
                console.printErrorMessage(e.getMessage());
            }
        }
    }

    private Selection getCode() {
        int selectionCode = console.getSelectionCode();
        return findByCode(selectionCode);
    }


    private void printAllPreviousData() {
        List<String> calculatedData = service.findAll();
        console.printExpressions(calculatedData);
    }

    private void printCalculatedResultAndSave() {
        String expression = console.getExpression();
        int result = service.calculate(expression);

        service.save(expression, result);

        console.printCalculatedResult(result);
    }

    private void exitProgram() {
        console.printEndMessage();
    }
}
