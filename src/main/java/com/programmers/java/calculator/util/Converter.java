package com.programmers.java.calculator.util;

public interface Converter<T, U> {

    U convert(T t);
}
