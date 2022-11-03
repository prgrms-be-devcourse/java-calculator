package calculator.calculator.history;

import calculator.calculator.formula.Formula;
import calculator.calculator.notation.calculation.CalculationResult;

public class CalculationHistoryForm {

    private final Formula formula;
    private final CalculationResult calculationResult;

    public CalculationHistoryForm(Formula formula, CalculationResult calculationResult) {
        this.formula = formula;
        this.calculationResult = calculationResult;
    }

    public Formula getFormula() {
        return formula;
    }

    public CalculationResult getCalculationResult() {
        return calculationResult;
    }
}
