package calculator;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandOption {
    SHOW_HISTORY("1"),
    CALCULATION("2"),
    QUIT("3"),
    INVALID("-1");

    private static final Map<String, CommandOption> validValues = initValidValueList();
    private final String value;

    CommandOption(String value) {
        this.value = value;
    }

    public static CommandOption createCommandOption(String target) {
        return Optional.ofNullable(validValues.get(target)).orElse(INVALID);
    }

    private static Map<String, CommandOption> initValidValueList(){
        return Collections.unmodifiableMap(
                Stream.of(values())
                        .collect(Collectors.toMap(CommandOption::getValue, Function.identity()))
        );
    }

    public String getValue() {
        return value;
    }
}
