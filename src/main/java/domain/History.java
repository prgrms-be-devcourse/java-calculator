package main.java.domain;

public class History {
    private String history;

    public History(String[] commandArr, int result) {
        this.history = String.join(" ", commandArr) + " = " + result;
    }

    public String getHistory() {
        return history;
    }
}
