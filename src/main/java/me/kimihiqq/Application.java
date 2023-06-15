package me.kimihiqq;

import me.kimihiqq.model.History;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        History history = new History();
        new Calculator(consoleInput, consoleOutput, history).run();
    }
}
