package com.programmers.java;

import com.programmers.java.calculator.PostfixCalculator;
import com.programmers.java.controller.Console;
import com.programmers.java.repository.InMemoryMapRepository;
import com.programmers.java.validator.FormValidator;
import com.programmers.java.validator.InputValidator;
import com.programmers.java.validator.MathExpressionValidator;
import com.programmers.java.validator.ParenthesesValidator;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<InputValidator> validatorList = new ArrayList<>();
        validatorList.add(new FormValidator());
        validatorList.add(new MathExpressionValidator());
        validatorList.add(new ParenthesesValidator());

        new Console(
                validatorList,
                new PostfixCalculator(),
                new InMemoryMapRepository()).run();
    }
}
