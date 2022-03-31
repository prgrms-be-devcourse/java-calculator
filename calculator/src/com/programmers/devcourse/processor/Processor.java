package com.programmers.devcourse.processor;

import com.programmers.devcourse.exception.processor.ProcessorException;

public interface Processor<T, R> {

  R process(T input) throws ProcessorException;
}
