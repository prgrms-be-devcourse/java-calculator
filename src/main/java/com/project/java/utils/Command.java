package com.project.java.utils;

public enum Command {
    RETRIEVE("1"), CALCULATE("2"), QUIT("q"), ANOTHER_QUIT("Q");

    final private String command;

    private Command(String command) {
        this.command = command;
    }
}
