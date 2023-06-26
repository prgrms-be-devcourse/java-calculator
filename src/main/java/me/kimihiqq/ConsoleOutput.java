package me.kimihiqq;

import me.kimihiqq.io.Output;

public class ConsoleOutput implements Output {
    @Override
    public void println() {
        System.out.println();
    }

    @Override
    public void println(String prompt) {
        System.out.println(prompt);
    }

    public void printResult(String result) {
        System.out.println("= " + result);
    }
}