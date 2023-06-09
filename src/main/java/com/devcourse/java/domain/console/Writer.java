package com.devcourse.java.domain.console;

public class Writer implements Output {

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void print(Number number) {
        System.out.println(number + "\n");
    }
}
