package com.devcourse.java.domain.console.io;

public class ConsoleWriter implements Writer {
    @Override
    public <T> void write(T value) {
        System.out.print(value);
    }
}
