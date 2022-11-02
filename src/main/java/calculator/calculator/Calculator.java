package calculator.calculator;

import calculator.calculator.formula.FormulaParser;
import calculator.calculator.notation.calculation.CalculationResult;
import calculator.calculator.notation.calculation.NotationCalculation;
import calculator.calculator.notation.parser.NotationParser;

import java.math.BigDecimal;

public class Calculator {

    private final NotationCalculation calculation;
    private final NotationParser notationParser;
    private final FormulaParser formulaParser;

    public Calculator(NotationCalculation calculation, NotationParser notationParser, FormulaParser formulaParser) {
        this.calculation = calculation;
        this.notationParser = notationParser;
        this.formulaParser = formulaParser;
    }

    public CalculationResult calculate(String formula) {
        return calculation.calculate(
                        notationParser.parseFrom(
                                formulaParser.parseFrom(formula)));
    }
}
