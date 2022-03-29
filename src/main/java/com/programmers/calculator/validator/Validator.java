package com.programmers.calculator.validator;

import com.programmers.calculator.exception.validation.ValidationException;

public interface Validator<T> {
    void validate(T t) throws ValidationException;
}
