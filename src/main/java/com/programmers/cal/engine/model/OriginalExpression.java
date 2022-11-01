package com.programmers.cal.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OriginalExpression {
    private InputData inputExpression;
    private List<String> originalTokens;

    @Builder
    public OriginalExpression(InputData inputExpression, List<String> originalTokens) {
        this.inputExpression = inputExpression;
        this.originalTokens = originalTokens;
    }

}
