package calculator.model.expression;

import calculator.model.token.Tokenizationable;

public class Expression {
    private final Tokenizationable[] tokenArray;

    public Expression(Tokenizationable[] tokenArray) {
        this.tokenArray = tokenArray;
    }

    public Tokenizationable[] getTokenArray() {
        return tokenArray;
    }
}
