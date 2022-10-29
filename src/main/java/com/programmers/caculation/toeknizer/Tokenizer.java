package com.programmers.caculation.toeknizer;

import com.programmers.caculation.model.NumberAndOperator;

import java.util.Collection;

public interface Tokenizer {
    Collection<NumberAndOperator> tokenize(String expression) throws Exception;
}
