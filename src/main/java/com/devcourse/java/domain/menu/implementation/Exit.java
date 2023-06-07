package com.devcourse.java.domain.menu.implementation;

import com.devcourse.java.domain.menu.Menu;

public class Exit implements Menu {
    public Exit() { }

    @Override
    public boolean execute() {
        return false;
    }
}
