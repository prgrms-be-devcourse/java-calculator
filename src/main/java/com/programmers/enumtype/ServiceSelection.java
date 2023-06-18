package com.programmers.enumtype;

import java.util.Arrays;
import java.util.Objects;

public enum ServiceSelection {
    NOT_SELECTED("0"),
    LOOKUP_RECORDS("1"),
    CALCULATION("2"),
    EXIT_SERVICE("3");

    private final String number;

    ServiceSelection(String number) {
        this.number = number;
    }

    public static ServiceSelection selectService(String number) {
        return Arrays.stream(values())
                .filter(service -> Objects.equals(service.number, number))
                .findAny()
                .orElse(NOT_SELECTED);
    }
}
