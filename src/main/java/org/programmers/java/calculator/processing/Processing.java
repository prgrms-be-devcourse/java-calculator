package org.programmers.java.calculator.processing;

import org.programmers.java.calculator.memory.Memory;
import org.programmers.java.calculator.service.CalculatorService;
import org.programmers.java.calculator.util.postfix.PostfixCalculator;
import org.programmers.java.calculator.util.postfix.PostfixTranslator;
import org.programmers.java.calculator.util.verifiaction.FormulaVerification;

import java.util.*;

public class Processing {
    private final PostfixTranslator postfixTranslator = new PostfixTranslator();
    private final PostfixCalculator postfixCalculator = new PostfixCalculator();
    private final Memory memory = new Memory();

    public String getMemory() {
        StringBuilder sb = new StringBuilder();
        memory.findAll().forEach(find -> {
            sb.append(find);
            sb.append("\n");
        });
        return sb.toString();
    }

    public String calculate(String input) {
        Optional<String> cache = memory.find(input);

        if (cache.isPresent()) {
            memory.save(input, cache.get());
            return cache.get();
        } else {
            String answer = getAnswer(input).toString();
            memory.save(input, answer);
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
