package java.calculator.common.utils;

public class Tokenizer {
    private final String[] tokens;

    public Tokenizer(String expression) {
        this.tokens = expression.split(" ");
    }

    public String[] getTokens() {
        return this.tokens;
    }
}


