package com.programmers;

import com.programmers.io.Input;
import com.programmers.io.Output;

import java.util.concurrent.atomic.AtomicBoolean;

public class CalculatorController implements Runnable {
    private final Input input;
    private final Output output;

    public CalculatorController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        AtomicBoolean running = new AtomicBoolean(true);

        while (running.get()) {
            output.displayMenu();
            Menu menu = input.selectMenu();

            switch (menu) {
                case HISTORY -> getHistory();
                case CALCULATE -> calculate();
                case EXIT -> running.set(false);
            }
        }
    }

    private void getHistory() {
    }

    private void calculate() {
    }
}
