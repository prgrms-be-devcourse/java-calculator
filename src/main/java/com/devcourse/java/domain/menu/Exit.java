package com.devcourse.java.domain.menu;

import com.devcourse.java.domain.console.Console;

import static com.devcourse.java.common.Messages.EXITING;

public class Exit implements Menu {

    public Exit() { }

    @Override
    public boolean execute(Console console) {
        console.print(EXITING.toMessage());
        return false;
    }
}
