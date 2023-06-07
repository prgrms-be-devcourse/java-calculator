package com.devcourse.java.domain.Runner;

import com.devcourse.java.common.Factory;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.Menus;
import org.apache.commons.lang3.StringUtils;

public class CalculatorRunner {
    private static final String EXIT = "Y";
    private final Factory<Menu, Menus> factory;
    private final Console console;

    public CalculatorRunner(Factory<Menu, Menus> factory, Console console) {
        this.factory = factory;
        this.console = console;
    }

    public void run() {
        boolean power = true;

        while (power) {
            int selectedMenu = console.selectMenu();
            Menus menus = Menus.of(selectedMenu);

            if (menus.isNotOnMenu() && confirmExit()) {
                continue;
            }

            Menu menu = factory.create(menus);
            power = menu.execute(console);
        }
    }

    private boolean confirmExit() {
        String closing = console.askIfExiting();
        return !StringUtils.equalsIgnoreCase(closing, EXIT);
    }
}
