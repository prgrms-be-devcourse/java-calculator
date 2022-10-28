package com.programmers.cal.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostfixExpression {
    private InputData inputExpression;
    private List<String> postfixTokens;

    @Builder
    public PostfixExpression(InputData inputExpression, List<String> postfixTokens) {
        this.inputExpression = inputExpression;
        this.postfixTokens = postfixTokens;
    }

}
