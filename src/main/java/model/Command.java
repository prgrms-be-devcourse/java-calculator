package model;

import java.util.Arrays;

public enum Command {
    HISTORY_COMMAND(1), CALCULATE_COMMAND(2);

    private final int number;

    Command(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Command getCommand(String input) {
        int command = Integer.parseInt(input);
        return Arrays.stream(values())
                .filter(cmd -> cmd.getNumber() == command)
                .findFirst()
                .orElseThrow();
    }
}
