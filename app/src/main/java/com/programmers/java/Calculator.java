package com.programmers.java;

import com.programmers.java.io.Screen;
import com.programmers.java.repository.Repository;

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
            int chosenNumber = screen.inputMenuNumber();

            switch (chosenNumber) {
                case 1:
                    screen.printHistory(repository.findAllHistory());
                    break;
                case 2:
                    String formula = screen.inputFormula();
                    String parsedFormula = parser.changeInfixToPostfix(formula);
                    int calculateResult = Integer.parseInt(calculate(parsedFormula));
                    repository.save(formula, calculateResult);
                    screen.printFormulaResult(calculateResult);
                    break;
                default:
                    return;
            }
        }
    }

    public String calculate(String parsedFormula) {
        Stack<Integer> numbers = new Stack<>();

        for (int i = 0; i < parsedFormula.length(); i++) {
            char c = parsedFormula.charAt(i);

            if (c >= '0' && c <= '9') {
                numbers.push(c - '0');
            } else {
                int num2 = numbers.pop();
                int num1 = numbers.pop();

                switch (c) {
                    case '+':
                        numbers.push(num1 + num2);
                        break;
                    case '-':
                        numbers.push(num1 - num2);
                        break;
                    case '/':
                        numbers.push(num1 / num2);
                        break;
                    case '*':
                        numbers.push(num1 * num2);
                        break;
                }
            }
        }

        return numbers.pop().toString();
    }
}
