import java.util.Arrays;

public enum CommandType {
    HISTORY_COMMAND(1), CALCULATE_COMMAND(2);

    private final int number;

    CommandType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static CommandType getCommandType(int command) {
        return Arrays.stream(values())
                .filter(cmd -> cmd.getNumber() == command)
                .findFirst().get();
    }
}
