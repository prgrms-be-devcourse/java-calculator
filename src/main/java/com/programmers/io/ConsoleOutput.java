package com.programmers.io;

public class ConsoleOutput implements Output{
    @Override
    public void showPrompt(String prompt) {
        System.out.print(prompt);
    }

    @Override
    public void showText(String text) {
        System.out.println(text);
    }
}
