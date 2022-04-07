package calculator.engine.model;

import java.util.Arrays;
import java.util.Optional;

public enum Menu {
    INQUIRY("1"),
    CALCULATION("2");

    private final String input;

    Menu(String input) {
        this.input = input;
    }

    public static Optional<Menu> getMenu(String input) {
        return Optional.ofNullable(
                Arrays.stream(Menu.values())
                        .filter(menu -> menu.input.equals(input))
                        .findAny()
                        .orElse(null)
        );
    }

}
