package calculator.domain.model;

import calculator.error.exception.WrongInputSymbolException;
import calculator.error.model.ResponseErrorFormat;

import java.util.Arrays;
import java.util.function.BinaryOperator;

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

    public static SymbolPriority from(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new WrongInputSymbolException(ResponseErrorFormat.FAIL_WRONG_INPUT_SYMBOL));
    }
}
