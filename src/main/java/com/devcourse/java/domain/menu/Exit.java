package com.devcourse.java.domain.menu;

import com.devcourse.java.domain.console.Console;

public class Exit implements Menu {
    private static final String EXITING = "계산기를 종료합니다.";

    public Exit() { }

    @Override
    public boolean execute(Console console) {
        console.write(EXITING);
        return false;
    }
}
