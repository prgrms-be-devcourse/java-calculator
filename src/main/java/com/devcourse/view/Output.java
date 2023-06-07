package com.devcourse.view;

import com.devcourse.calc.model.Menu;

import java.util.Arrays;

public class Output {

    public static void init() {
        Menu[] menus = Menu.values();
        Arrays.stream(menus).forEach(System.out::println);
        System.out.print("\n선택 : ");
    }

    public static void viewResult(String result) {
        System.out.println(result);
    }

    public static void blankLine() {
        System.out.println();
    }
}
