package com.programmers.java;

import com.programmers.java.engine.Computer;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        Computer computer = new Computer(console, console);
        computer.run();
    }

}
