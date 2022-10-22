package calculator.calculator.history;

import java.util.HashMap;

import static calculator.exception.HistoryException.HISTORY_SAVE_EXCEPTION;

public class CalculationHistory {

    private static final HashMap<String, Double> histories = new HashMap<>();

    public void save(String formula, Double answer) {
        if (checkSaveFormWrong(formula, answer)) {
            throw new IllegalArgumentException(HISTORY_SAVE_EXCEPTION.message);
        }
        histories.put(formula, answer);
    }

    private static boolean checkSaveFormWrong(String formula, Double answer) {
        return formula.length() == 0 || answer.isNaN();
    }

    public HashMap<String, Double> findAllHistories() {
        return cloneHistories();
    }

    private HashMap<String, Double> cloneHistories() {
        return (HashMap<String, Double>) histories.clone();
    }
}
