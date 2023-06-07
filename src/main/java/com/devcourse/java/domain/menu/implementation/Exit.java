package com.devcourse.java.domain.menu.implementation;

import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.menu.Menu;

public class Exit implements Menu {
    public Exit() { }

    @Override
    public boolean execute(Console console) {
        console.exiting();
        return false;
    }
}
