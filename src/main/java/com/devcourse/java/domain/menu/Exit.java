package com.devcourse.java.domain.menu;

import com.devcourse.java.domain.console.Console;

public class Exit implements Menu {
    public Exit() { }

    @Override
    public boolean execute(Console console) {
        console.exiting();
        return false;
    }
}
