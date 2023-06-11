package com.programmers.java.view;

import lombok.Getter;

@Getter
public enum Button {
    SEARCH("1"),CALCULATE("2");
    private final String value;
    Button(String value) { this.value = value; }

}
