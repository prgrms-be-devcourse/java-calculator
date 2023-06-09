package com.devcourse.java.domain.calculator;

import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.validator.Validator;

public interface Calculator {
    CalculateResult run(String expression, Validator validator);
}
