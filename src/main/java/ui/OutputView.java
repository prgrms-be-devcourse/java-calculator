package ui;

import util.Menu;

import java.util.List;
import java.util.function.Predicate;

public class OutputView {
    private static final String SELECT_MSG = "선택 : ";
    private static final String LIMIT_MSG = "회 남았습니다.";
    private static final String END_MSG = "시도 횟수 초과로 종료합니다.";

    private void println(String msg) {
        System.out.println(msg);
    }

    private void print(String msg) {
        System.out.print(msg);
    }

    private void printSelectMsg() {
        print(SELECT_MSG);
    }

    public void printMenu() {
        for (Menu menu : Menu.values()) {
            println(menu.getPrintMsg());
        }
        printSelectMsg();
    }

    public void printErrorMsg(String errorMsg) {
        println(errorMsg);
    }

    public void printLimitMsg(int limit) {
        if (limit == 0) {
            println(END_MSG);
            return;
        }
        println(limit + LIMIT_MSG);
    }

    public void printEmptyMsg() {
        println("");
    }

    public void printResult(double result) {
        println(String.valueOf(result));
        printEmptyMsg();
    }

    public void printCalculators(List<String> calculators) {
        printEmptyMsg();
        calculators.stream().forEach(System.out::println);
        printEmptyMsg();
    }
}




