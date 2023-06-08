package main.java.view;

import main.java.domain.Menu;
import main.java.repository.Repository;

import static main.java.view.ConsoleInput.ERROR_MESSAGE;
import static main.java.view.ConsoleInput.scannerClose;

public class ConsoleOutput implements Output{

    private static final String EXIT_MESSAGE = "EXIT CALCULATOR PROGRAM";
    public static final String EMPTY_MESSAGE = "This repository is EMPTY!!";

    // 자원정리의 주체가 output이 돼도 되나?
    @Override
    public void exitProgram() {
        scannerClose();
        System.out.println(EXIT_MESSAGE);
    }

    @Override
    public void showHistory(Repository repository) {
        repository.showHistory();
    }

    public void printError() {
        System.out.println(ERROR_MESSAGE);
    }
    @Override
    public void printMenu() {
        Menu[] menus = Menu.values();
        for(int i = 0; i < menus.length - 1; i++)
            System.out.println(menus[i]);
        System.out.println(menus[menus.length - 1].getMenuName());
    }

}
