package com.programmers.java.engine.calculator;

import com.programmers.java.engine.model.Expression;

public interface Calculator<T> {
    T calculate(Expression expression);
}
