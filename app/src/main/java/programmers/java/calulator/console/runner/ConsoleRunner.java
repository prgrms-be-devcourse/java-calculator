package programmers.java.calulator.console.runner;

import programmers.java.calulator.common.runner.ApplicationRunner;
import programmers.java.calulator.console.menu.MenuHandler;

public class ConsoleRunner implements ApplicationRunner {
    private final MenuHandler menuHandler;

    public ConsoleRunner(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    @Override
    public void run() {
        while (true) {
            menuHandler.printMenu();
            String menu = menuHandler.readMenu();
            menuHandler.getCommand(menu).execute();
        }
    }
}
