package com.devcourse.engine.validator;

import com.devcourse.engine.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.devcourse.engine.exception.InvalidInputException.INVALID_EXPRESSION;

public class SimpleValidator implements Validator {

    private static final String REGEXP = "(?:^\\.[0-9]+)|(?:^[0-9]?\\.[\\s+\\-*/]$)|([0-9]+\\.[0-9]+)|([+\\-*/)(])|([0-9]+)|(s*)";
    private static final Pattern pattern = Pattern.compile(REGEXP);


    int operandCount;
    int branketCount;

    @Override
    public List<String> validate(String userInput) throws InvalidInputException {
        List<String> expression = new ArrayList<>();
        Matcher matcher = pattern.matcher(userInput);

        operandCount = 0;
        branketCount = 0;

        while (matcher.find()) {
            String token = matcher.group();
            if (token.isBlank())
                continue;
            branchIsBranketCondition(token);
            expression.add(token);
        }
        checkCountValidation(operandCount, cnt -> cnt < 1);
        return expression;
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
            throw new InvalidInputException(INVALID_EXPRESSION);
    }


}
