package com.devcourse.view;

import com.devcourse.calc.model.Menu;

public class Output {

    public static void init() {
        Menu[] menus = Menu.values();
        for (int i = 1; i < menus.length; i++) {
            System.out.print(menus[i]);
        }
        System.out.print("\n선택 : ");
    }

    public static void viewResult(String result) {
        System.out.println(result);
    }

    public static void blankLine() {
        System.out.println();
    }
}
