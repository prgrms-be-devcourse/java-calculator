package com.programmers.domain;

import com.programmers.exception.ExpressionDividedByZeroException;
import com.programmers.exception.ExpressionEmptyException;
import com.programmers.exception.ExpressionFormatException;
import com.programmers.exception.ExpressionOtherCharacterException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Expression {

    private static final String OTHER_PATTERN = "^[+\\-*/\\d]*$";
    private static final String NOT_OPERATOR_PATTERN = "[^+\\-*/]";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";
    private static final String NOT_NUMBER_PATTERN = "[^0-9]";

    private String input;

    public Expression(String input) {
        if (input.isEmpty()) {
            throw new ExpressionEmptyException();
        }

        checkOtherCharacter(input);
        this.input = input;
    }

    public void checkOtherCharacter(String input) {
        if (!Pattern.matches(OTHER_PATTERN, input)) {
            throw new ExpressionOtherCharacterException();
        }
    }

    public List<String> parse() {
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, OPERATOR_PATTERN, true);

        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        return tokens;
    }

    public List<String> getValidatedTokens() {
        List<String> tokens = parse();
        checkEvenNumber(tokens);
        checkFormat(tokens);
        checkDividedByZero(tokens);

        return tokens;
    }

    public void checkEvenNumber(List<String> tokens) {
        if (tokens.size() == 1 || tokens.size() % 2 == 0) {
            throw new ExpressionFormatException();
        }
    }

    public void checkFormat(List<String> tokens) {
        for (int index = 0; index < tokens.size(); index++) {
            if (!checkRightToken(index, tokens)) {
                throw new ExpressionFormatException();
            }
        }
    }

    public boolean checkRightToken(int index, List<String> tokens) {
        if (index % 2 == 0) {
            return !Pattern.matches(NOT_NUMBER_PATTERN, tokens.get(index));
        }

        return !Pattern.matches(NOT_OPERATOR_PATTERN, tokens.get(index));
    }

    public void checkDividedByZero(List<String> tokens) {
        for (int index = 0; index < tokens.size() - 1; index++) {
            String tokenOne = tokens.get(index);
            String tokenTwo = tokens.get(index + 1);

            if (tokenOne.equals("/") && tokenTwo.equals("0")) {
                throw new ExpressionDividedByZeroException();
            }
        }
    }
}
