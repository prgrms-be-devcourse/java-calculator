package com.programmers.java;

import com.programmers.java.exception.MenuInputException;
import com.programmers.java.io.Console;
import com.programmers.java.model.History;
import com.programmers.java.repository.Repository;
import com.programmers.java.util.FormulaParser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Calculator implements Runnable {
    private final String newLine = System.lineSeparator();
    private final String MENU = "1. 조회" + newLine + "2. 계산" + newLine + newLine + "선택 : ";
    private final String LOOKUP = "1";
    private final String CALCULATION = "2";

    private Console console;
    private Repository repository;
    private FormulaParser parser;

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
                switch (console.inputMenuNumber()) {
                    case LOOKUP:
                        console.printHistory(repository.findAllHistory());
                        break;
                    case CALCULATION:
                        String formula = console.inputFormula();

                        if (repository.haveFormulaResult(formula)) {
                            console.printFormulaResult(repository.findFormulaResult(formula));
                        } else {
                            int calculateResult = calculate(parser.changeInfixToPostfix(formula));
                            repository.save(formula, new History(formula, calculateResult));
                            console.printFormulaResult(calculateResult);
                        }
                        break;
                    default:
                        throw new MenuInputException();
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
