package com.devcourse.java.domain.parser;

import com.devcourse.java.domain.validator.Validator;

import java.util.List;

public interface ExpressionParser {
    List<String> parse(String expression, Validator validator);
}
