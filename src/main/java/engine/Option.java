package engine;

import lombok.Getter;
import lombok.ToString;

public enum Option {
    EXIT("0", "종료"),
    HISTORY("1", "조회"),
    CALCULATE("2", "계산");

    private String option;
    private String command;

    Option(String option, String command) {
        this.option = option;
        this.command = command;
    }

    public String getOption() {
        return option;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return "Option{" +
                "option='" + option + '\'' +
                ", command='" + command + '\'' +
                '}';
    }
}
