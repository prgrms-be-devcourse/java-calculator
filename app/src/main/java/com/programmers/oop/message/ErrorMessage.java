package com.programmers.oop.message;

public enum ErrorMessage {
    CLIENT_ERROR("4xx", "잘못된 입력입니다."),
    INTERNAL_ERROR("5xx", "잘못된 입력입니다.");

    private String statusCode;
    private String message;

    ErrorMessage(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
            "statusCode='" + statusCode + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
