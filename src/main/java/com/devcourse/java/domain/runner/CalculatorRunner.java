package com.devcourse.java.domain.runner;

import com.devcourse.java.domain.factory.Factory;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.Menus;
import org.apache.commons.lang3.StringUtils;

public class CalculatorRunner {
    private static final String EXIT = "Y";
    private static boolean power = true;
    private final Factory<Menu, Menus> factory;
    private final Console console;

    public CalculatorRunner(Factory<Menu, Menus> factory, Console console) {
        this.factory = factory;
        this.console = console;
    }

    public void run() {
        while (power) {
            String selectedMenu = console.selectMenu();
            Menus menus = Menus.from(selectedMenu);

            if (menus.isNotOnMenu() && confirmExit()) {
                continue;
            }

            Menu menu = factory.create(menus);
            power = menu.execute(console);
        }
    }

    private boolean confirmExit() {
        String closing = console.confirmExiting();
        return !StringUtils.equalsIgnoreCase(closing, EXIT);
    }
}
