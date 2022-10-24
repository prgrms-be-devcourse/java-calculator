package calculator.calculator.history;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import static calculator.exception.HistoryException.HISTORY_SAVE_EXCEPTION;

public class CalculationHistory implements History {

    private static final HashMap<String, BigDecimal> histories = new HashMap<>();
    private static final int HISTORY_FORMULA_INDEX = 0;
    private static final int HISTORY_ANSWER_INDEX = 1;

    @Override
    public void save(String... history) {
        String formula = history[HISTORY_FORMULA_INDEX];
        BigDecimal answer = new BigDecimal(history[HISTORY_ANSWER_INDEX]);

        if (checkSaveFormWrong(formula, answer)) {
            throw new IllegalArgumentException(HISTORY_SAVE_EXCEPTION.message);
        }
        histories.put(formula, answer);
    }

    private static boolean checkSaveFormWrong(String formula, BigDecimal answer) {
        return formula.length() == 0 || answer == null;
    }

    @Override
    public Collection<?> findAllHistories() {
        return cloneHistories().entrySet();
    }

    private HashMap<String, Double> cloneHistories() {
        return (HashMap<String, Double>) histories.clone();
    }
}
