package calculator.calculator.history;

import calculator.calculator.formula.Formula;
import calculator.calculator.notation.calculation.CalculationResult;

import java.util.Map;

public interface History {
    void save(CalculationHistoryForm calculationResult);
    Map<Formula, CalculationResult> findAllHistories();
}
