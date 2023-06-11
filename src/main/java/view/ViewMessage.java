package view;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ViewMessage {
    COMMAND_ONE("1. 조회"), COMMAND_TWO("2. 계산"), SELECT("선택 : ");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getFormattedMessage() {
        StringBuilder sb = new StringBuilder();
        String infoMessage = Arrays.stream(values())
                .filter(elem -> !elem.equals(ViewMessage.SELECT))
                .map(ViewMessage::getMessage)
                .collect(Collectors.joining("\n"));
        return sb.append(infoMessage)
                .append("\n\n")
                .append(SELECT.getMessage())
                .toString();
    }
}
