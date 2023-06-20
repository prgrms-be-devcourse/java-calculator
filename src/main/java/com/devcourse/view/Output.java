package com.devcourse.view;

import com.devcourse.calc.model.Menu;

public class Output {

    private Output() {
    }

    public static void showMenus() {
        for (Menu menu : Menu.allMenus()) {
            System.out.println(menu);
        }
        System.out.print("\n선택 : ");
    }

    public static void viewResult(String result) {
        System.out.println(result.concat("\n"));
    }

    public static void blankLine() {
        System.out.println();
    }
}
