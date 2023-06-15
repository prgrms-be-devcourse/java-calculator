package com.wonu606.calculator;

import com.wonu606.app.App;
import com.wonu606.calculator.calculator.PostfixCalculator;
import com.wonu606.calculator.converter.InfixToPostfixConverter;
import com.wonu606.calculator.storage.Persistence;
import com.wonu606.calculator.storage.ResultStore;
import com.wonu606.calculator.strategy.CalculationStrategy;
import com.wonu606.calculator.strategy.CalculatorStrategy;
import com.wonu606.calculator.util.CalculatorMessage;
import com.wonu606.calculator.validator.InfixValidator;
import com.wonu606.io.Input;
import com.wonu606.io.Print;
import java.util.HashMap;
import java.util.Map;

public class CalculatorApp implements App {

    private final Map<String, CalculatorStrategy> strategies = new HashMap();
    private final Persistence store = new ResultStore();

    public CalculatorApp() {
        initStrategies();
    }

    private void initStrategies() {
        strategies.put("1", new CalculationStrategy(
                new InfixValidator(), new InfixToPostfixConverter(), new PostfixCalculator()));
    }

    public void execute(Input input, Print printer) {

        while (true) {
            String selection = inputMenuSelection(input);
            CalculatorStrategy selectedStrategy = getStrategyOrThrow(selection);
            performStrategy(input, printer, selectedStrategy);
        }
    }

    private void performStrategy(Input input, Print printer, CalculatorStrategy selectedStrategy) {
        selectedStrategy.execute(input, printer, store);
    }

    private CalculatorStrategy getStrategyOrThrow(String selection) {
        CalculatorStrategy selectedStrategy = strategies.get(selection);
        if (selectedStrategy == null) {
            throw new IllegalArgumentException(CalculatorMessage.INVALID_INPUT.message);
        }
        return selectedStrategy;
    }

    private String inputMenuSelection(Input input) {
        return input.getInput();
    }
}
