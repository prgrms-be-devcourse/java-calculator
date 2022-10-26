package org.programmers.java.calculator.controller;

import org.programmers.java.calculator.service.CalculatorService;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;
import org.programmers.java.calculator.util.postfix.PostfixCalculator;
import org.programmers.java.calculator.util.postfix.PostfixTranslator;
import org.programmers.java.calculator.util.verifiaction.FormulaVerification;

import java.util.*;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();
    private final PostfixTranslator postfixTranslator = new PostfixTranslator();
    private final PostfixCalculator postfixCalculator = new PostfixCalculator();

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
        String postfixExpression = infixToPostfix(input);
        String  answer = postfixCalculator(postfixExpression).toString();
        return answer;
    }

    private Double postfixCalculator(String info) {
        return postfixCalculator.calculate(info);
    }

    private String infixToPostfix(String token) {
        return postfixTranslator.infixToPostfix(token).toString();
    }

    private void parse(String input) {
        List<String> tokens = Arrays.asList(input.split(" "));
        FormulaVerification.formulaVerifiaction(tokens);
    }
}
