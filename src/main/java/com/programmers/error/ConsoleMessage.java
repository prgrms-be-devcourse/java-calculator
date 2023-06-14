package com.programmers.error;

public enum ConsoleMessage {
    INPUT_RETRY_MESSAGE("다시 입력하세요.");

    private final String consoleMessage;
    ConsoleMessage(String message){
        this.consoleMessage = message;
    }
}
