package calculator.adapter;

import calculator.ConsoleInput;
import calculator.adapter.CalculateHandler;
import calculator.adapter.CalculatorHandler;
import calculator.adapter.LookupHandler;

import java.util.Arrays;
import java.util.Optional;

public enum CalculatorAdapter {

    LOOKUP("1", new LookupHandler()),
    CALCULATE("2", new CalculateHandler(new ConsoleInput()));

    private String option;
    private CalculatorHandler handler;

    CalculatorAdapter(String option, CalculatorHandler handler) {
        this.option = option;
        this.handler = handler;
    }

    public static Optional<String> handle(String option) {
        return Arrays.stream(values())
                .filter(adapter -> adapter.option.equals(option))
                .findFirst()
                .map(adapter -> adapter.handler.process());
    }
}
