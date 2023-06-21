package main.java.view;

import main.java.domain.History;
import main.java.domain.Menu;

import java.util.List;

public interface Output {

    void exitProgram();
    void showHistory(List<History> historyList);

    void printMenu(Menu[] menus);
    void printResult(int result);

}
