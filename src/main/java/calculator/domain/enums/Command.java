package calculator.domain.enums;

import calculator.exception.ApplicationException;
import calculator.exception.ErrorMessage;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {
    HISTORY("1"),
    CALCULATION("2"),
    EXIT("3")
    ;

    private final String number;

    Command(String number) {
        this.number = number;
    }

    private static final Map<String, Command> COMMAND_MAP = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Command::getNumber, Function.identity())));

    public static Command from(String number) {
        return Optional.ofNullable(COMMAND_MAP.get(number))
                .orElseThrow(() -> new ApplicationException(ErrorMessage.NOT_FOUND_OPTION));
    }

    public String getNumber() {
        return this.number;
    }

    public boolean isHistory() {
        return HISTORY.equals(this);
    }

    public boolean isCalculation() {
        return CALCULATION.equals(this);
    }

    public boolean isExit() {
        return EXIT.equals(this);
    }
}
