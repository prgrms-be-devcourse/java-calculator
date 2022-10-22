package calculator.engine.controller;

import calculator.engine.io.Input;
import calculator.engine.io.Output;

public class Controller implements Runnable{
    private final Calculator calculator;
    private final Input input;
    private final Output output;

    public Controller(Calculator calculator, Input input, Output output) {
        this.calculator = calculator;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        while(true) {

        }
    }
}
