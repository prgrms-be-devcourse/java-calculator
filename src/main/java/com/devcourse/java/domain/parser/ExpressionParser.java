package com.devcourse.java.domain.parser;

import java.util.List;

public interface ExpressionParser {
    List<Character> parse(String expression);
}
