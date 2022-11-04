package com.programmers.java.engine;

import com.programmers.java.engine.option.Option;

public class Menu {
    public void processMenu(Option option) throws Exception {
        option.runOption();
    }
}
