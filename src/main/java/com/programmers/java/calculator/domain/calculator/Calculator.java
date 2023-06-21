package com.programmers.java.calculator.domain.calculator;

public interface Calculator<T, U> {

    U calculate(T t);
}
