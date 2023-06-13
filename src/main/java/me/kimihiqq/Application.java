package me.kimihiqq;

import me.kimihiqq.model.History;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        History history = new History();
        new Calculator(console, console, history).run();
    }
}
