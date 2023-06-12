package com.devcourse.engine.validator;

import com.devcourse.engine.exception.InvalidInputException;

import java.util.List;

public interface Validator {
    List<String> validate(String userInput) throws InvalidInputException;
}
