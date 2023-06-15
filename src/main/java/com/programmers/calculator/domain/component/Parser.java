package com.programmers.calculator.domain.component;

import java.util.List;

public interface Parser {
    public List<String> parseToTokens(String expression);
}
