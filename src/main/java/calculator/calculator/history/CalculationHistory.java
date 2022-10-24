package calculator.calculator.history;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

import static calculator.exception.HistoryException.HISTORY_SAVE_EXCEPTION;

public class CalculationHistory implements History {

    private static final HashMap<String, String> histories = new HashMap<>();
    private static final int HISTORY_FORMULA_INDEX = 0;
    private static final int HISTORY_ANSWER_INDEX = 1;

    @Override
    public void save(String... history) {
        String formula = history[HISTORY_FORMULA_INDEX];
        String answer = history[HISTORY_ANSWER_INDEX];

        if (checkSaveFormWrong(formula, answer)) {
            throw new NumberFormatException(HISTORY_SAVE_EXCEPTION.message);
        }

        saveEachCase(formula, answer);
    }

    private void saveEachCase(String formula, String answer) {
        if (checkDecimal(answer)) {
            answer = new BigDecimal(answer).stripTrailingZeros().toString();
        }

        histories.put(formula, answer);
    }

    private boolean checkDecimal(String answer) {
        return answer.contains(".");
    }

    private boolean checkSaveFormWrong(String formula, String answer) {
        return formula.length() == 0 || answer.length() == 0;
    }

    @Override
    public Collection<?> findAllHistories() {
        return cloneHistories().entrySet();
    }

    private HashMap<String, String> cloneHistories() {
        return (HashMap<String, String>) histories.clone();
    }
}
