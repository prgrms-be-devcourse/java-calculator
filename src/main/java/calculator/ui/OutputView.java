package calculator.ui;

import util.Menu;

import java.util.function.Predicate;

public class OutputView {
    private static final String SELECT_MSG = "선택 : ";

    private void println(String msg) {
        System.out.println(msg);
    }

    private void print(String msg) {
        System.out.print(msg);
    }

    public void printMenu() {
        for (Menu menu : Menu.values()) {
            println(menu.getPrintMsg());
        }
        printSelectMsg();
    }

    private void printSelectMsg() {
        print(SELECT_MSG);
    }

    public void printErrorMsg(String errorMsg) {
        println(errorMsg);
    }
}




