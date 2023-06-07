package com.devcourse.java.domain.Runner;

import com.devcourse.java.common.Factory;
import com.devcourse.java.common.Input;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.Menus;
import org.apache.commons.lang3.StringUtils;

public class CalculatorRunner {
    private static final String EXIT = "Y";
    private final Factory<Menu, Menus> factory;

    public CalculatorRunner(Factory factory) {
        this.factory = factory;
    }

    public void run() {
        boolean power = true;

        while (power) {
            int selectedMenu = Input.selectMenu();
            Menus menus = Menus.of(selectedMenu);

            if (menus.isNotOnMenu() && confirmExit()) {
                continue;
            }

            Menu menu = factory.create(menus);
            power = menu.execute();
        }
    }

    private boolean confirmExit() {
        String closing = Input.askIfExiting();
        return !StringUtils.equalsIgnoreCase(closing, EXIT);
    }
}
