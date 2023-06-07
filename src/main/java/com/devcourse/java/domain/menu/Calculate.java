package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Storage;
import com.devcourse.java.domain.Result.Result;
import com.devcourse.java.domain.console.Console;

public class Calculate implements Menu {
    private static Calculate INSTANCE;

    private final Storage<Result> storage;

    private Calculate(Storage storage) {
        this.storage = storage;
    }

    public static Calculate getInstance(Storage storage) {
        if (INSTANCE == null) {
            INSTANCE = new Calculate(storage);
        }
        return INSTANCE;
    }

    @Override
    public boolean execute(Console console) {
        return true;
    }
}
