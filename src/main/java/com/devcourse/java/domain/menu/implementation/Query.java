package com.devcourse.java.domain.menu.implementation;

import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.menu.Menu;

public class Query implements Menu {
    private static Query INSTANCE;

    private Query() { }

    public static Query getInstance() {
        if (INSTANCE == null) {
            return new Query();
        }
        return INSTANCE;
    }

    @Override
    public boolean execute(Console console) {
        return true;
    }
}
