package com.devcourse.engine.computer;

import com.devcourse.engine.exception.InvalidInputException;
import com.devcourse.engine.model.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Computer {

    private static final String REGEXP = "([0-9]+)|([+\\-*/])|(\s*)";
    private static final Pattern pattern = Pattern.compile(REGEXP);

    public List<String> validate(String userInput) {
        List<String> expression = new ArrayList<>();
        Matcher matcher = pattern.matcher(userInput);
        int count = 0;
        while (matcher.find()) {
            String token = matcher.group();
            if (token.isBlank())
                continue;
            if (Character.isDigit(token.charAt(0))) {
                if (++ count > 1)
                    throw new InvalidInputException("올바르지 않은 식입니다.");
            } else {
                if (-- count < 0)
                    throw new InvalidInputException("올바르지 않은 식입니다.");
            }
            expression.add(token);
        }
        if (count < 1)
            throw new InvalidInputException("올바르지 않은 식입니다.");
        return expression;
    }

    public Stack<String> convert(List<String> expression) {
        return new Stack<>();
    }

    public double compute(List<String> expression) {
        return 0.0;
    }
}
