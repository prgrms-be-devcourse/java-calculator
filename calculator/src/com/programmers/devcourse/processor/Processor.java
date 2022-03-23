package com.programmers.devcourse.processor;

public interface Processor<T, R> {

  R process(T input);
}
