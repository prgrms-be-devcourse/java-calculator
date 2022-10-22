package com.programmers.java;

import com.programmers.java.exception.ChosenNumberNotInMenuException;
import com.programmers.java.io.Screen;
import com.programmers.java.repository.Repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Calculator implements Runnable {
    private final Screen screen;
    private final Repository repository;
    private final FormulaParser parser;
    private final String MENU = "1. 조회\n2. 계산\n\n선택 : ";

    public Calculator(Screen screen, Repository repository, FormulaParser parser) {
        this.screen = screen;
        this.repository = repository;
        this.parser = parser;
    }

    @Override
    public void run() {
        while (true) {
            screen.printMenu(MENU);

            try {
                int chosenNumber = screen.inputMenuNumber();

                switch (chosenNumber) {
                    case 1:
                        screen.printHistory(repository.findAllHistory());
                        break;
                    case 2:
                        String formula = screen.inputFormula();
                        int calculateResult = calculate(parser.changeInfixToPostfix(formula));
                        repository.save(formula, calculateResult);
                        screen.printFormulaResult(calculateResult);
                        break;
                    default:
                        throw new ChosenNumberNotInMenuException();
                }
            } catch (Exception e) {
                screen.printErrorMessage(e.getMessage());
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
