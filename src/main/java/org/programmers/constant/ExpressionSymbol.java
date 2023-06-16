package org.programmers.constant;

public enum ExpressionSymbol {
    EQUAL_SYMBOL("="), BLANK_SYMBOL(" ");

    private final String symbol;

    ExpressionSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
