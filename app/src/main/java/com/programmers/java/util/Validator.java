package com.programmers.java.util;

import com.programmers.java.exception.FormulaInputException;
import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.CloseBracket;
import com.programmers.java.model.token.letter.bracket.OpenBracket;
import com.programmers.java.model.token.letter.number.Number;
import com.programmers.java.model.token.letter.operator.*;

import java.util.Stack;

public class Validator {
    public String validateFormula(String formula) throws FormulaInputException {
        String[] tokens = formula.split("((?=[^0-9])|(?<=[^0-9]))");

        if (validateTokenIsCorrectLetter(tokens)
                && validateFormulaNotEmpty(tokens)
                && validateBracketIsCouple(tokens)
                && validateFormulaOrderIsCorrect(tokens)) {
            return formula;
        }
        throw new FormulaInputException();
    }

    private boolean validateTokenIsCorrectLetter(String[] tokens) {
        for (String token : tokens) {
            if (!(Number.isNumber(token)
                    || Operator.isOperator(token)
                    || OpenBracket.isOpen(token)
                    || CloseBracket.isClose(token))) {
                return false;
            }
        }
        return true;
    }

    private boolean validateFormulaNotEmpty(String[] tokens) {
        if (tokens == null) {
            return false;
        }
        return true;
    }

    private boolean validateBracketIsCouple(String[] tokens) {
        Stack<String> openBracketStack = new Stack<>();

        for (String token : tokens) {
            if (OpenBracket.isOpen(token)) {
                openBracketStack.push(token);
            } else if (CloseBracket.isClose(token)) {
                if (openBracketStack.isEmpty()) {
                    return false;
                } else {
                    if (OpenBracket.isOpen(openBracketStack.peek())) {
                        openBracketStack.pop();
                    }
                }
            }
        }
        if (!openBracketStack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean validateFormulaOrderIsCorrect(String[] tokens) {
        return validateFirstTokenIsCorrect(tokens)
                && validateMiddleTokenIsCorrect(tokens)
                && validateLastTokenIsCorrect(tokens);
    }

    private boolean validateMiddleTokenIsCorrect(String[] tokens) {
        for (int i = 0; i < tokens.length - 1; i++) {
            Token curToken = validateCorrectToken(tokens[i]);
            Token nextToken = validateCorrectToken(tokens[i + 1]);

            if (!curToken.checkNextTokenCorrect(nextToken)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateFirstTokenIsCorrect(String[] tokens) {
        if (OpenBracket.isOpen(tokens[0]) || Number.isNumber(tokens[0])) {
            return true;
        }
        return false;
    }

    private boolean validateLastTokenIsCorrect(String[] tokens) {
        if (Number.isNumber(tokens[tokens.length - 1]) || CloseBracket.isClose(tokens[tokens.length - 1])) {
            return true;
        }
        return false;
    }

    public Token validateCorrectToken(String token) {
        if (Number.isNumber(token)) {
            return new Number(token);
        } else if (PlusOperator.isPlus(token)) {
            return new PlusOperator(token);
        } else if (MinusOperator.isMinus(token)) {
            return new MinusOperator(token);
        } else if (MultiplyOperator.isMultiply(token)) {
            return new MultiplyOperator(token);
        } else if (DivideOperator.isDivide(token)) {
            return new DivideOperator(token);
        } else if (OpenBracket.isOpen(token)) {
            return new OpenBracket(token);
        } else {
            return new CloseBracket(token);
        }
    }
}
