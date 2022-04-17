package calculator.engine.model;

import java.util.HashMap;
import java.util.Map;

public class HistoryDatabase {
    private static int count;
    private Map<Integer, String> histories;

    public HistoryDatabase() {
        count = 0;
        this.histories = new HashMap<>();
    }

    public void addHistory(String arith, Double result) {
        histories.put(++count, arith + " = " + Math.round(result * 1000) / 1000.0);
    }

    public Map<Integer, String> getHistories() {
        return this.histories;
    }
}
