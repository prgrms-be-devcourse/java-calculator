package com.devcourse.java.domain.validator;

import com.devcourse.java.domain.console.Console;

import java.util.List;

import static com.devcourse.java.common.Messages.EMPTY_STORAGE;

public class Validator {
    public Validator() { }

    public boolean isNotEmpty(List target, Console console) {
        if (target.isEmpty()) {
            console.print(EMPTY_STORAGE.toMessage());
            return false;
        }
        return true;
    }
}
