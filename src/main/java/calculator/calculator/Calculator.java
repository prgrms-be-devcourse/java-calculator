package calculator.calculator;

import calculator.calculator.formula.Formula;
import calculator.calculator.formula.FormulaParser;
import calculator.calculator.history.CalculationHistoryForm;
import calculator.calculator.notation.calculation.CalculationResult;
import calculator.calculator.notation.calculation.NotationCalculation;
import calculator.calculator.notation.parser.NotationParser;

public class Calculator {

    private final NotationCalculation calculation;
    private final NotationParser notationParser;
    private final FormulaParser formulaParser;

    public Calculator(NotationCalculation calculation, NotationParser notationParser, FormulaParser formulaParser) {
        this.calculation = calculation;
        this.notationParser = notationParser;
        this.formulaParser = formulaParser;
    }

    public CalculationHistoryForm calculate(String formula) {
        Formula parsedFormula = formulaParser.parseFrom(formula);
        Formula parsedNotation = notationParser.parseFrom(parsedFormula);
        CalculationResult calculationResult = calculation.calculate(parsedNotation);

        return new CalculationHistoryForm(parsedFormula, calculationResult);
    }
}
