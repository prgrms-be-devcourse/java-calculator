package com.programmers.java;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.exception.MenuInputException;

import java.util.Stack;

public class Validator {
    private FormulaParser parser;

    public Validator(FormulaParser parser) {
        this.parser = parser;
    }

    public int checkMenuInputIsNumber(String chosenNumber) throws MenuInputException {
        try {
            return Integer.parseInt(chosenNumber);
        } catch (NumberFormatException e) {
            throw new MenuInputException();
        }
    }

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

    public boolean isNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
            return true;
        }

        return false;
    }

    public boolean isOpenBracket(String token) {
        if (token.equals("(")) {
            return true;
        }

        return false;
    }

    public boolean isCloseBracket(String token) {
        if (token.equals(")")) {
            return true;
        }

        return false;
    }
}
