package com.devcourse.engine.model.validator;

import com.devcourse.engine.model.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {

    private static final String REGEXP = "(?:^\\.[0-9]+)|(?:^[0-9]?\\.[\\s+\\-*/]$)|([0-9]+\\.[0-9]+)|([+\\-*/)(])|([0-9]+)|(s*)";
    private static final Pattern pattern = Pattern.compile(REGEXP);


    int operandCount;
    int branketCount;

    public List<String> validate(String userInput) throws InvalidInputException {
        List<String> expressions = new ArrayList<>();
        Matcher matcher = pattern.matcher(userInput);

        operandCount = 0;
        branketCount = 0;

        while (matcher.find()) {
            String token = matcher.group();
            if (token.isBlank())
                continue;
            branchIsBranketCondition(token);
            expressions.add(token);
        }
        checkCountValidation(operandCount, cnt -> cnt < 1);
        return expressions;
    }

    private void branchIsBranketCondition(String token) {
        char prefix = token.charAt(0);

        if (prefix == '(' || prefix == ')') {
            branchBranket(prefix);
            return;
        }
        branchIsDigitCondition(prefix);
    }

    private void branchBranket(char prefix) {
        if (prefix == '(') {
            branketCount ++;
            return;
        }
        checkCountValidation(-- branketCount, cnt -> cnt < 0);
    }

    private void branchIsDigitCondition(char prefix) {
        if (Character.isDigit(prefix)) {
            checkCountValidation(++ operandCount, cnt -> cnt > 1);
            return;
        }
        checkCountValidation(-- operandCount, cnt -> cnt < 0);
    }


    private void checkCountValidation(int count, Predicate<Integer> predicate) {
        if (predicate.test(count))
            throw new InvalidInputException(InvalidInputException.INVALID_EXPRESSION);
    }


}
