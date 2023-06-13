package com.programmers.java.view;

import java.util.List;

public class Output {
    public void viewStartConsole() {
        for (Menu menu : Menu.values()) {
            System.out.println(menu.toString());
        }
    }

    public void viewEndConsole() {
        System.out.println("계산기를 종료합니다.");
    }

    public void viewCalculateResult(double result) {
        System.out.println(result);
    }

    public void viewSearchResult(List<String> calcList) {
        for (String calc : calcList) {
            System.out.println(calc);
        }
    }
}