package com.programmers.calculator.domain.component;

import com.programmers.calculator.domain.vo.Expression;

import java.util.List;

public interface Parser {
    public List<String> parseToTokens(Expression expression);
}
