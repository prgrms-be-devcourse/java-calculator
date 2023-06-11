package co.programmers.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UserMenu {
    INQUIRY("1"),
    CALCULATE("2"),
    TERMINATE("3");

    private static final Map<String, UserMenu> values =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(UserMenu::getValue, Function.identity())));
    private final String value;

    UserMenu(String value) {
        this.value = value;
    }

    public static UserMenu get(String input) {
        return Optional.ofNullable(values.get(input)).orElse(TERMINATE);
    }

    public String getValue() {
        return value;
    }
}