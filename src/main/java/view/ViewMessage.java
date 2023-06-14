package view;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ViewMessage {
    HISTORY_COMMAND("1. 조회", 1), CALCULATE_COMMAND("2. 계산", 2), SELECT_COMMAND("선택 : ", -1);

    private final String message;
    private final int commandNumber;

    ViewMessage(String message, int commandNumber) {
        this.message = message;
        this.commandNumber = commandNumber;
    }

    public String getMessage() {
        return message;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public static String getFormattedMessage() {
        StringBuilder sb = new StringBuilder();
        String infoMessage = Arrays.stream(values())
                .filter(elem -> !elem.equals(ViewMessage.SELECT_COMMAND))
                .map(ViewMessage::getMessage)
                .collect(Collectors.joining("\n"));

        return sb.append(infoMessage)
                .append("\n\n")
                .append(SELECT_COMMAND.getMessage())
                .toString();
    }

    public static ViewMessage getViewMessage(String input) {
        int command = Integer.parseInt(input);

        return Arrays.stream(values())
                .filter(cmd -> cmd.getCommandNumber() == command)
                .findFirst()
                .orElseThrow();
    }
}
