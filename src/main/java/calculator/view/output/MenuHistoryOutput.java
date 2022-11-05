package calculator.view.output;

import calculator.calculator.formula.Formula;
import calculator.calculator.notation.calculation.CalculationResult;

import java.util.Map;

import static calculator.view.output.TextUnit.*;

public class MenuHistoryOutput implements BaseOutput {

    public void printHistories(Map<Formula, CalculationResult> histories) {
        print(createHistories(histories) + ENTER.getUnit());
    }

    private String createHistories(Map<Formula, CalculationResult> histories) {
        StringBuilder textBuilder = new StringBuilder();
        histories.forEach((formula, calculationResult) -> {
            handleFormula(textBuilder, formula);
            handleCalculationResult(textBuilder, calculationResult);
        });

        return textBuilder.toString();
    }

    private static void handleCalculationResult(StringBuilder textBuilder, CalculationResult calculationResult) {
        String result = calculationResult.getResult();
        textBuilder.append(EQUAL.getUnit())
                .append(SPACE.getUnit())
                .append(result)
                .append(ENTER.getUnit());
    }

    private static void handleFormula(StringBuilder textBuilder, Formula formula) {
        formula.getFormulaPieces()
                .forEach(formulaPiece ->
                        textBuilder.append(formulaPiece)
                                .append(SPACE.getUnit())
                );
    }
}
