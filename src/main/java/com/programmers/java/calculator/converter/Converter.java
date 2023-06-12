package com.programmers.java.calculator.converter;

public interface Converter<T, U> {

    U convert(T t);
}
