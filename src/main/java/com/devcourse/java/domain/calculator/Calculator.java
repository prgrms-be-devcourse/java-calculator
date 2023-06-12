package com.devcourse.java.domain.calculator;

import com.devcourse.java.domain.storage.CalculateResult;

public interface Calculator {
    CalculateResult run(String expression);
}
