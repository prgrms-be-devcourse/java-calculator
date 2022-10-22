package calculator.calculator.history;

import java.util.HashMap;

public class CalculationHistory {

    private static final HashMap<String, Double> histories = new HashMap<>();

    public void save(String formula, Double answer) {
        histories.put(formula, answer);
    }

    public HashMap<String, Double> findAllHistories() {
        return cloneHistories();
    }

    private HashMap<String, Double> cloneHistories() {
        return (HashMap<String, Double>) histories.clone();
    }
}
