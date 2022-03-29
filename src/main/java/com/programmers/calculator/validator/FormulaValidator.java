package com.programmers.calculator.validator;

import com.programmers.calculator.exception.validation.FormulaValidationException;
import com.programmers.calculator.exception.validation.ValidationException;

import java.util.Stack;

public class FormulaValidator implements Validator<String> {

    private static FormulaValidator validator;

    private FormulaValidator() {
    }

    public static FormulaValidator getInstance() {
        validator = new FormulaValidator();
        return validator;
    }

    @Override
    public void validate(String formula) throws ValidationException {
        if (!checkBracket(formula)) {
            throw new FormulaValidationException();
        }
    }

    private boolean checkBracket(String formula) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            char temp = formula.charAt(i);
            if (temp == '(') {
                stack.push(temp);
            } else if (temp == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
