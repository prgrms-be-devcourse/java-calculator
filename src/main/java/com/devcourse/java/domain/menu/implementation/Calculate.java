package com.devcourse.java.domain.menu.implementation;

import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.menu.Menu;

public class Calculate implements Menu {
    private static Calculate INSTANCE;
    private Calculate() { }

    public static Calculate getInstance() {
        if (INSTANCE == null) {
            return new Calculate();
        }
        return INSTANCE;
    }

    @Override
    public boolean execute(Console console) {
        return true;
    }
}
