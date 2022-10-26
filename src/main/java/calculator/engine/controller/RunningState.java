package calculator.engine.controller;

public class RunningState {
    private boolean state = true;

    public void exit() {
        state = false;
    }

    public boolean isRunning() {
        return state;
    }
}
