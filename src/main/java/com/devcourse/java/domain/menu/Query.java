package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Storage;
import com.devcourse.java.domain.Result.Result;
import com.devcourse.java.domain.console.Console;

public class Query implements Menu {
    private static Query INSTANCE;

    private final Storage<Result> storage;

    private Query(Storage storage) {
        this.storage = storage;
    }

    public static Query getInstance(Storage storage) {
        if (INSTANCE == null) {
            INSTANCE = new Query(storage);
        }
        return INSTANCE;
    }

    @Override
    public boolean execute(Console console) {
        return true;
    }
}
