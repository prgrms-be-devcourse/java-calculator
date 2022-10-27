package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Expression {
    String[] tokens;

    @Builder
    public Expression(String[] tokens) {
        this.tokens = tokens;
    }
}
