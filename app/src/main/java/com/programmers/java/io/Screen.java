package com.programmers.java.io;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.exception.MenuInputNotNumberException;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Screen implements Input, Output, Validate {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int inputMenuNumber() throws MenuInputNotNumberException {
        int chosenNumber = menuInputIsNumberValidate(scanner.nextLine());
        System.out.println();
        return chosenNumber;
    }

    @Override
    public String inputFormula() throws FormulaInputException {
        String formula = formulaValidate(scanner.nextLine());
        return formula;
    }

    @Override
    public void printMenu(String menu) {
        System.out.print(menu);
    }

    @Override
    public void printHistory(List<String> history) {
        history.forEach(System.out::println);
    }

    @Override
    public void printFormulaResult(Integer result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    @Override
    public int menuInputIsNumberValidate(String chosenNumber) throws MenuInputNotNumberException {
        try {
            return Integer.parseInt(chosenNumber);
        } catch (NumberFormatException e) {
            throw new MenuInputNotNumberException();
        }
    }

    @Override
    public String formulaValidate(String formula) throws FormulaInputException {
        String[] formulaSplit = formula.split("((?=[^0-9])|(?<=[^0-9]))");
        Stack<String> openBracket = new Stack<>();

        for (String token : formulaSplit) {
            if (!(isNumber(token) || isOperator(token) || isOpenBracket(token) || isCloseBracket(token))) {
                throw new FormulaInputException();
            }
        }

        if (formulaSplit.length == 0) {
            throw new FormulaInputException();
        }

        for (String token : formulaSplit) {
            if (token.equals("(")) {
                openBracket.push(token);
            } else if (token.equals(")")) {
                if (openBracket.isEmpty()) {
                    throw new FormulaInputException();
                } else {
                    if (openBracket.peek().equals("(")) {
                        openBracket.pop();
                    }
                }
            }
        }
        if (!openBracket.isEmpty()) {
            throw new FormulaInputException();
        }

        if (!(formulaSplit[0].equals("(") || isNumber(formulaSplit[0]))) {
            throw new FormulaInputException();
        }
        for (int i = 0; i < formulaSplit.length - 1; i++) {
            if (isNumber(formulaSplit[i])) {
                if (!(isOperator(formulaSplit[i + 1]) || isCloseBracket(formulaSplit[i + 1]))) {
                    throw new FormulaInputException();
                }
            }
            if (isOperator(formulaSplit[i])) {
                if (!(isNumber(formulaSplit[i + 1]) || isOpenBracket(formulaSplit[i + 1]))) {
                    throw new FormulaInputException();
                }
            }
            if (isOpenBracket(formulaSplit[i])) {
                if (!(isNumber(formulaSplit[i + 1]) || isOpenBracket(formulaSplit[i + 1]))) {
                    throw new FormulaInputException();
                }
            }
            if (isCloseBracket(formulaSplit[i])) {
                if (!(isOperator(formulaSplit[i + 1]) || isCloseBracket(formulaSplit[i + 1]))) {
                    throw new FormulaInputException();
                }
            }
        }

        if (!(isNumber(formulaSplit[formulaSplit.length - 1]) || isCloseBracket(formulaSplit[formulaSplit.length - 1]))) {
            throw new FormulaInputException();
        }

        return formula;
    }

    @Override
    public boolean isNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isOpenBracket(String token) {
        if (token.equals("(")) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isCloseBracket(String token) {
        if (token.equals(")")) {
            return true;
        }

        return false;
    }
}
