package com.programmers.java;

import com.programmers.java.exception.ChosenNumberNotInMenuException;
import com.programmers.java.io.Console;
import com.programmers.java.repository.Repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Calculator implements Runnable {
    private final Console console;
    private final Repository repository;
    private final FormulaParser parser;
    private final String MENU = "1. 조회\n2. 계산\n\n선택 : ";

    public Calculator(Console console, Repository repository, FormulaParser parser) {
        this.console = console;
        this.repository = repository;
        this.parser = parser;
    }

    @Override
    public void run() {
        while (true) {
            console.printMenu(MENU);

            try {
                int chosenNumber = console.inputMenuNumber();

                switch (chosenNumber) {
                    case 1:
                        console.printHistory(repository.findAllHistory());
                        break;
                    case 2:
                        String formula = console.inputFormula();
                        int calculateResult;

                        if (repository.haveFormulaResult(formula)) {
                            calculateResult = repository.findFormulaResult(formula);
                        } else {
                            calculateResult = calculate(parser.changeInfixToPostfix(formula));
                            repository.save(formula, calculateResult);
                        }
                        console.printFormulaResult(calculateResult);
                        break;
                    default:
                        throw new ChosenNumberNotInMenuException();
                }
            } catch (Exception e) {
                console.printErrorMessage(e.getMessage());
            }
        }
    }

    public int calculate(String[] parsedFormula) {
        Stack<Integer> numbers = new Stack<>();
        HashSet<String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));


        for (int i = 0; i < parsedFormula.length; i++) {
            if (!operator.contains(parsedFormula[i])) {
                numbers.push(Integer.parseInt(parsedFormula[i]));
            } else {
                int num2 = numbers.pop();
                int num1 = numbers.pop();

                switch (parsedFormula[i]) {
                    case "+":
                        numbers.push(num1 + num2);
                        break;
                    case "-":
                        numbers.push(num1 - num2);
                        break;
                    case "/":
                        numbers.push(num1 / num2);
                        break;
                    case "*":
                        numbers.push(num1 * num2);
                        break;
                }
            }
        }

        return numbers.pop();
    }
}
