package org.example.compute;

public class ComputeManager {
    private boolean state;

    public ComputeManager(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
