package me.kimihiqq.options;

public enum Option {
    LIST("1"),
    CALCULATE("2");

    private final String value;

    Option(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Option from(String value) {
        for (Option option : Option.values()) {
            if (option.getValue().equals(value)) {
                return option;
            }
        }
        return null;
    }
}
