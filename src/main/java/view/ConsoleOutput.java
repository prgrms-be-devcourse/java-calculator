package main.java.view;

import main.java.domain.History;
import main.java.domain.Menu;

import java.util.List;

public class ConsoleOutput implements Output{

    private static final String EXIT_MESSAGE = "EXIT calculate ..";
    public static final String EMPTY_MESSAGE = "Repository is EMPTY!!";

    public static String printError(String error) {
        return "WRONG " + error + " ! PLEASE RE-TYPE!!";
    }

    // 자원정리의 주체가 output이 돼도 되나?
    @Override
    public void exitProgram() {
        System.out.println(EXIT_MESSAGE);
    }

    @Override
    public void printResult(int result) {
        System.out.println(result);
    }

    @Override
    public void showHistory(List<History> historyList) {
        if(historyList.isEmpty()) {
            System.out.println(EMPTY_MESSAGE);
            return;
        }
        for(History historyEntity : historyList) {
            System.out.println(historyEntity.getHistory());
        }
    }

    @Override
    public void printMenu(Menu[] menus) {
        for(int i = 1; i < menus.length; i++) {
            System.out.println(menus[i]);
        }
        System.out.println(menus[0].getMenuName());
    }

}
