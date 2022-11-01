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
            String[] enumName = Arrays.stream(values()).filter(element->element.value.equals(string))
                    .map(Enum::toString).toArray(String[]::new);
            return Menu.valueOf(enumName[0]);
         } catch(Exception e){
            return DEFAULT;
        }
    }
}
