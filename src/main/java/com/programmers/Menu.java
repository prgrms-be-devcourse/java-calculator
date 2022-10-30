package com.programmers;

import java.util.Arrays;

public enum Menu {
    RECORD("1"),CACULATION("2"),EXIT("3"),DEFAULT("");
    final private String value;
    Menu(String input) {
        this.value = input;
    }

    public static Menu getMenu(String string){
        try {
            String name = Arrays.stream(values()).filter(element->element.value.equals(string)).toString();
            return Menu.valueOf(name);
         } catch(Exception e){
            return DEFAULT;
        }
    }
}
