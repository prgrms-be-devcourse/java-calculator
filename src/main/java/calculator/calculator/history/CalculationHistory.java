package calculator.calculator.history;

import calculator.calculator.formula.Formula;
import calculator.calculator.notation.calculation.CalculationResult;

import java.util.HashMap;
import java.util.Map;

import static calculator.exception.HistoryException.HISTORY_SAVE_EXCEPTION;

public class CalculationHistory implements History {

    private static final Map<Formula, CalculationResult> histories = new HashMap<>();

    @Override
    public void save(CalculationHistoryForm calculationHistoryForm) {
        Formula formula = calculationHistoryForm.getFormula();
        CalculationResult calculationResult = calculationHistoryForm.getCalculationResult();

        if (checkSaveFormWrong(formula, calculationResult)) {
            throw new NumberFormatException(HISTORY_SAVE_EXCEPTION.getMessage());
        }

        saveEachCase(formula, calculationResult);
    }

    private void saveEachCase(Formula formula, CalculationResult calculationResult) {
        histories.put(formula, calculationResult);
    }

    private boolean checkSaveFormWrong(Formula formula, CalculationResult answer) {
        String saveFormula = formula.getFormulaWithNoSpace();
        String saveCalculationResult = answer.getResult().toPlainString();
        return saveFormula.isBlank() || saveCalculationResult.isBlank();
    }

    @Override
    public Map<Formula, CalculationResult> findAllHistories() {
        Map<Formula, CalculationResult> cloneHistories = new HashMap<>();
        histories.forEach((formula, calculationResult) ->
                cloneHistories.put(formula.clone(), calculationResult.clone()));
        return cloneHistories;
    }
}
