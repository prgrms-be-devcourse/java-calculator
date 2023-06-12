package com.wonu606.calculator;

import com.wonu606.app.App;
import com.wonu606.calculator.storage.Persistence;
import com.wonu606.calculator.storage.ResultStore;
import com.wonu606.calculator.strategy.CalculatorStrategy;
import com.wonu606.io.Input;
import com.wonu606.io.Print;
import com.wonu606.calculator.util.CalculatorMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CalculatorApp implements App {

    private final Map<String, CalculatorStrategy> strategies = new HashMap();
    private final Persistence store = new ResultStore();

    public CalculatorApp() {
        initStrategies();
    }

    private void initStrategies() {
        // TODO 조회와 계산 기능을 생성하여 추가해야 함
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
