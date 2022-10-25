package org.programmers.java.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;
import org.programmers.java.calculator.util.verifiaction.FormulaVerification;

import java.util.Optional;

@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorServiceImpl calculatorServiceImpl;

    public String record() {
        return calculatorServiceImpl.record();
    }

    public String calculate(String input) {
        Optional<String> cache = calculatorServiceImpl.find(input);
        if (cache.isPresent()) {
            return cache.get();
        } else {
            String answer = getAnswer(input);
            calculatorServiceImpl.save(input, answer);
            return answer;
        }
    }

    private String getAnswer(String input) {
        FormulaVerification.formulaVerifiaction(input);
        return "";
    }
}
