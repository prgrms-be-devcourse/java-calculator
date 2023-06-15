package me.kimihiqq;

import me.kimihiqq.model.History;

public class Application {
    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        History history = new History();
        Calculator calculator = new Calculator(consoleInput, consoleOutput, history);

        boolean running = true;
        while (running) {
            running = calculator.run();
        }
    }
}
