package com.wonu606.io;

public class ConsolePrinter implements Print {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void print(int number) {
        print(String.valueOf(number));
    }

    @Override
    public void tearDown() {
    }
}
