package org.programmers.io;

public class Console {
    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }
}
