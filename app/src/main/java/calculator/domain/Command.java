package calculator.domain;

import calculator.exception.InvalidCommandException;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    GETALLDATA("조회", "1"),
    CALCULATE("계산", "2"),
    EXIT("종료", "0");

    private static final Map<String, Command> commands
            = new HashMap<>() {
        {
            put(GETALLDATA.code, GETALLDATA);
            put(CALCULATE.code, CALCULATE);
            put(EXIT.code, EXIT);
        }
    };

    private final String code;
    private final String command;

    Command(String command, String code) {
        this.command = command;
        this.code = code;
    }

    public static Command getCommand(String command) {
        if (!commands.containsKey(command)) throw new InvalidCommandException();
        return commands.get(command);
    }

    public String getCode() {
        return code;
    }

    public String getCommand() {
        return command;
    }
}
