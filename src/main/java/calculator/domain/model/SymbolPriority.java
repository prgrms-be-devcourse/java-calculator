package calculator.domain.model;

import calculator.error.exception.WrongInputSymbolException;
import calculator.error.model.ResponseErrorFormat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SymbolPriority {

    ADD("+", 0, (a, b) -> a + b),
    SUB("-", 0, (a, b) -> a - b),
    MUL("*", 1, (a, b) -> a * b),
    DIV("/", 1, (a, b) -> a / b),
    ;

    private final String symbol;
    private final int priority;
    private final BinaryOperator<Integer> formula;

    SymbolPriority(String symbol,
                   int priority,
                   BinaryOperator<Integer> formula) {
        this.symbol = symbol;
        this.priority = priority;
        this.formula = formula;
    }

    public int getPriority() {

        return priority;
    }

    public String getSymbol() {
        return symbol;
    }

    public BinaryOperator<Integer> getFormula() {

        return formula;
    }

    private static final Map<String, SymbolPriority> symbolPriorities =
            Collections.unmodifiableMap(Arrays.stream(values())
                    .collect(Collectors.toMap(SymbolPriority::getSymbol, Function.identity())));

    public static SymbolPriority from(String symbol) {
        return Optional.ofNullable(symbolPriorities.get(symbol))
                .orElseThrow(() -> new WrongInputSymbolException(ResponseErrorFormat.FAIL_WRONG_INPUT_SYMBOL));
    }
}
