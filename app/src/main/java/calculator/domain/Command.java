package calculator.domain;

public enum Command {
    GETALLDATA("조회", "1"),
    CALCULATE("계산", "2");

    private final String code;
    private final String command;

    Command(String command, String code) {
        this.command = command;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getCommand() {
        return command;
    }
}
