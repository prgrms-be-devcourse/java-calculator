package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Expression {
    private List<String> tokens;
    private String originExpression;

    @Builder
    public Expression(List<String> tokens) {
        this.tokens = tokens;
        this.originExpression = initOriginExpression();
    }

    private String initOriginExpression() {
        return String.join(" ", tokens);
    }
}
