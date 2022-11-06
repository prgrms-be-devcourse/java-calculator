package engine.option;

import engine.exception.NotValidInputException;

public enum Option {
    EXIT("0", "종료"),
    HISTORY("1", "조회"),
    CALCULATE("2", "계산");

    private final String option;
    private final String command;

    Option(String option, String command) {
        this.option = option;
        this.command = command;
    }

    public static String makeOptionList() {
        StringBuilder sb = new StringBuilder();
        for (Option o : Option.values()) {
            sb.append(o.ordinal()).append(". ").append(o.getCommand()).append('\n');
        }
        return sb.toString();
    }

    public static void checkUserInput(String userCommand) {
        if (userCommand.length() != 1 || !Character.isDigit(userCommand.charAt(0)))
            throw new NotValidInputException("잘못된 입력값입니다.");

        if (userCommand.equals(EXIT.option) || userCommand.equals(HISTORY.option) || userCommand.equals(CALCULATE.option)) {
            return;
        } else {
            throw new NotValidInputException("잘못된 입력값입니다.");
        }
    }

    public String getCommand() {
        return command;
    }

    public String getOption() {
        return option;
    }

    @Override
    public String toString() {
        return "Option{" +
                "option='" + option + '\'' +
                ", command='" + command + '\'' +
                '}';
    }
}
