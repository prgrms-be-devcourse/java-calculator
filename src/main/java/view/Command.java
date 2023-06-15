package view;

import exception.NoSuchCommandException;
import util.CalculatorUtils;

import java.util.Arrays;

public enum Command {
    HISTORY_COMMAND(1),
    CALCULATE_COMMAND(2);

    private final int commandNumber;

    Command(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public static Command resolveCommand(String input) {
        int command = CalculatorUtils.parseStringToInteger(input);
        return Arrays.stream(values())
                .filter(cmd -> cmd.getCommandNumber() == command)
                .findFirst()
                .orElseThrow(NoSuchCommandException::new);
    }
}
