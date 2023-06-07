package com.devcourse.view;

import com.devcourse.calc.model.Menu;

public class Output {

    private Output() {
    }

    public static void init() {
        Menu.menus.values()
                .forEach(System.out::println);
        System.out.print("\n선택 : ");
    }

    public static void viewResult(String result) {
        System.out.println(result);
    }

    public static void blankLine() {
        System.out.println();
    }
}
