package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Expression {
    private String[] tokens;
    private String originExpression;

    @Builder
    public Expression(String[] tokens) {
        this.tokens = tokens;
        this.originExpression = initOriginExpression();
    }

    private String initOriginExpression() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tokens.length-1; i++) {
            stringBuilder.append(tokens[i]).append(" ");
        }
        stringBuilder.append(tokens[tokens.length - 1]);

        return stringBuilder.toString();
    }
}
