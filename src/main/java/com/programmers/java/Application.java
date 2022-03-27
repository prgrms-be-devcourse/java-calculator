package com.programmers.java;
public class Application {
    public static void main(String[] args){
        Console console = new Console();
        new Calculator(console,console).run();
    }
}
