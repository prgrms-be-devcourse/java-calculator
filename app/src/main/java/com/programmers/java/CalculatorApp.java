package com.programmers.java;

import com.programmers.java.calculator.PostfixCalculator;
import com.programmers.java.controller.Console;
import com.programmers.java.repository.InMemoryMapRepository;
import com.programmers.java.validator.FormValidator;
import com.programmers.java.validator.MathExpressionValidator;
import com.programmers.java.validator.ParenthesesValidator;

public class CalculatorApp {
    public static void main(String[] args) {
        new Console(
                new PostfixCalculator(),
                new InMemoryMapRepository(),
                new FormValidator(), new MathExpressionValidator(), new ParenthesesValidator()).run();
    }
}
