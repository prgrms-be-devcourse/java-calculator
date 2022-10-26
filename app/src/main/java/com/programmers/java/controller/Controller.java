package com.programmers.java.controller;

public interface Controller {
    void run();

    String getInput(String prompt);

    boolean isNotValidated(String input);
}
