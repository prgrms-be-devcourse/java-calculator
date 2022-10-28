package com.programmers.java.engine.model;

import com.programmers.java.application.exception.UnknownOptionException;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuType {
    HISTORY("1"),
    CALCULATE("2"),
    EXIT("3");

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

    public static MenuType findMenuType(String option) throws UnknownOptionException {
        return Optional.ofNullable(menuMaps.get(option))
                .orElseThrow(() -> new UnknownOptionException("1, 2, 3 중 하나를 입력해주세요.\n"));
    }
}
