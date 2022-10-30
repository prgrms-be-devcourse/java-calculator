package com.programmers.caculation.toeknizer;

import com.programmers.caculation.model.NumberAndOperator;

import java.util.List;

public interface Tokenizer {
    List<NumberAndOperator> tokenize(String expression) throws Exception;
}
