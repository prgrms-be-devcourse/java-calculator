package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class StringExpression {
    private String value;

    @Builder
    public StringExpression(String value) {
        this.value = value;
    }
}
