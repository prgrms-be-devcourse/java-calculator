package org.programmers.java.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.service.CalculatorService;
import org.programmers.java.calculator.util.postfix.PostfixTranslator;
import org.programmers.java.calculator.util.verifiaction.FormulaVerification;

import java.util.*;

@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final PostfixTranslator postfixTranslator = new PostfixTranslator();

    public String calculationResult() {
        return calculatorService.calculationResult();
    }

    public String calculate(String input) {
        Optional<String> cache = calculatorService.find(input);
        if (cache.isPresent()) {
            return cache.get();
        } else {
            String answer = getAnswer(input).toString();
            calculatorService.save(input, answer);
            return answer;
        }
    }

    private Double getAnswer(String input) {
        List<String> token = parse(input);
        Double answer = postfixTranslator.infixToPostfix(token);
        return answer;
    }

    private List<String> parse(String input) {
        List<String> tokens = Arrays.asList(input.replace(" ", "").split(""));
        FormulaVerification.formulaVerifiaction(tokens);
        return tokens;
    }
}
