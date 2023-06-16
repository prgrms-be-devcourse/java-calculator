package com.devcourse.engine.model.validator;

import com.devcourse.engine.model.exception.InvalidInputException;

import java.util.List;

public interface Validator {
    List<String> validate(String userInput) throws InvalidInputException;
}
