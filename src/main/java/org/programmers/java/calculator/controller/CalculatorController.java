package org.programmers.java.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.service.CalculatorService;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;
import org.programmers.java.calculator.util.postfix.PostfixTranslator;
import org.programmers.java.calculator.util.verifiaction.FormulaVerification;

import java.util.*;

@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();
    private final PostfixTranslator postfixTranslator = new PostfixTranslator();

    public String calculationResult() {
        return calculatorService.calculationResult();
    }

    public String calculate(String input) {
        Optional<String> cache = calculatorService.find(input);
        if (cache.isPresent()) {
            calculatorService.save(input, cache.get());
            return cache.get();
        } else {
            String answer = getAnswer(input).toString();
            calculatorService.save(input, answer);
            return answer;
        }
    }

    private String getAnswer(String input) {
        parse(input);
        String answer = infixToPostfix(input);
        return answer;
    }

    private String infixToPostfix(String token) {
        try {
            return postfixTranslator.infixToPostfix(token).toString();
        } catch (IllegalArgumentException | ArithmeticException | IllegalStateException exception) {
            return exception.getMessage();
        }
    }

    private String parse(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));
        return FormulaVerification.formulaVerifiaction(tokens);
    }
}
