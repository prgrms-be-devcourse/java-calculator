package com.programmers.java.engine.model;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuType {
    HISTORY("1"),
    CALCULATE("2"),
    EXIT("3"),
    UNKNOWN("-1");

    final private String value;

    public String getValue() {
        return value;
    }

    MenuType(String value) {
        this.value = value;
    }

    private static final Map<String, MenuType> menuMaps = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(MenuType::getValue, Function.identity()))
    );

    public static MenuType find(String option) {
        return Optional.ofNullable(menuMaps.get(option))
                .orElseThrow();
    }
}
