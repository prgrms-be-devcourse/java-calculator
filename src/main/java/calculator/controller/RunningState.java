package calculator.controller;

public class RunningState {
    private boolean state;

    public RunningState(boolean state) {
        this.state = state;
    }

    public boolean isRunning() {
        return state;
    }

    public void exitProcess() {
        state = false;
    }
}
