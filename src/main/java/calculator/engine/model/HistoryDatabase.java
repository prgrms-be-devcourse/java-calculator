package calculator.engine.model;

import java.util.ArrayList;

public class HistoryDatabase {
    private ArrayList<String> histories;

    public HistoryDatabase() {
        this.histories = new ArrayList<>();
    }

    public void addHistory(String arith, Double result) {
        histories.add(arith + " = " + Math.round(result * 1000) / 1000.0);
    }

    public ArrayList<String> getHistories() {
        return this.histories;
    }
}
