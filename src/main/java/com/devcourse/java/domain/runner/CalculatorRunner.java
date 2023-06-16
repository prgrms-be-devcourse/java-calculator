package com.devcourse.java.domain.runner;

import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.MenuMapper;
import com.devcourse.java.domain.menu.MenuType;
import org.apache.commons.lang3.StringUtils;

public class CalculatorRunner {
    private static final String EXIT = "Y";
    private static boolean power = true;
    private final MenuMapper mapper;
    private final Console console;

    public CalculatorRunner(MenuMapper mapper, Console console) {
        this.mapper = mapper;
        this.console = console;
    }

    public void run() {
        while (power) {
            String selectedMenu = console.selectMenu();
            MenuType menuType = MenuType.from(selectedMenu);

            if (menuType.isNotOnMenu() && confirmExit()) {
                continue;
            }

            Menu menu = mapper.toMenu(menuType);
            power = menu.execute(console);
        }
    }

    private boolean confirmExit() {
        String closing = console.confirmExiting();
        return !StringUtils.equalsIgnoreCase(closing, EXIT);
    }
}
