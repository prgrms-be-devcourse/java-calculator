package com.wonu606.calculator.converter;

public interface Converter<T, R> {

    R convert(T input);
}
