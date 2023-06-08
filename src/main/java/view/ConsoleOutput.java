package main.java.view;

import main.java.domain.Menu;
import main.java.repository.Repository;

import static main.java.util.PrintOutMessage.EXIT_MESSAGE;
import static main.java.view.ConsoleInput.scannerClose;

public class ConsoleOutput implements Output{

    public static String printError(String error) {
        return "WRONG " + error + " ! PLEASE RE-TYPE!!";
    }

    // 자원정리의 주체가 output이 돼도 되나?
    @Override
    public void exitProgram() {
        scannerClose();
        System.out.println(EXIT_MESSAGE);
    }

    @Override
    public void printResult(int result) {
        System.out.println(result);
    }

    // 다형성 이용.
    @Override
    public void showHistory(Repository repository) {
        repository.showHistory();
    }
    @Override
    public void printMenu() {
        Menu[] menus = Menu.values();
        for(int i = 1; i < menus.length; i++)
            System.out.println(menus[i]);
        System.out.println(menus[0].getMenuName());
    }

}
