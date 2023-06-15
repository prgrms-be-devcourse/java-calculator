package org.programmers.controller;

import org.programmers.constant.Selection;
import org.programmers.domain.expression.ExpressionResult;
import org.programmers.io.Console;
import org.programmers.repository.Repository;

public class AppController {

    private final Console console;
    private final Repository repository;
    private final CalculatorManagement calculatorManagement;

    public AppController(Console console, Repository repository, CalculatorManagement calculatorManagement) {
        this.console = console;
        this.repository = repository;
        this.calculatorManagement = calculatorManagement;
    }

    public void run() {
        while (true) {
            console.getOutput().printConsole();
            int number = console.getInput().inputNumber();
            Selection selection = Selection.find(number);

            switch (selection) {
                case ERROR:
                    console.getOutput().printError();
                    break;
                case HISTORY:
                    getAllAndPrint();
                    break;
                case CALCULATION:
                    computeAndPrint();
                    break;
                case EXIT:
                    return;
            }
        }
    }

    private void getAllAndPrint() {
        console.getOutput().printHistory(repository.getAll());
    }

    private void computeAndPrint() {
        String inputExpression = console.getInput().inputExpression();
        try {
            ExpressionResult expressionResult = calculatorManagement.runCalculator(inputExpression);
            console.getOutput().printAnswer(expressionResult.getAnswer());
            repository.save(expressionResult);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 식을 입력하였습니다.");
        }
    }
}
