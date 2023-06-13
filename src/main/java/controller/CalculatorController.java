package controller;

import io.CalculatorInput;
import io.CalculatorOutput;

public class CalculatorController implements Runnable {
    private final CalculatorInput input;
    private final CalculatorOutput output;

    public CalculatorController(CalculatorInput input, CalculatorOutput output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        while (true) {
            //no switch
        }
    }
}
