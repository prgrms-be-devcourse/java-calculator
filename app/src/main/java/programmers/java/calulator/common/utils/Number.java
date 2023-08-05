package programmers.java.calulator.common.utils;

import java.util.Optional;

public class Number {
    private static final String NUMBER_REGEX = "-?\\d+";
    private final String token;

    private Number(String token) {
        this.token = token;
    }
    public static Optional<Number> of(String token) {
        return Optional.of(token)
                .filter(Number::isValid)
                .map(Number::new);
    }

    private static boolean isValid(String token) {
        return token.matches(NUMBER_REGEX);
    }

    public int toInt() {
        return Integer.parseInt(this.token);
    }
}

