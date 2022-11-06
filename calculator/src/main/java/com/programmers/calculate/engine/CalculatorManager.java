package com.programmers.calculate.engine;

public class CalculatorManager {
    private Boolean runnable = true;

    public Boolean isRunnable() {
        return runnable;
    }

    public void stopRunnable() {
        runnable = false;
    }

}
