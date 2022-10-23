package calculator.calculator;

import calculator.calculator.formula.FormulaParser;
import calculator.calculator.notation.calculation.NotationCalculation;
import calculator.calculator.notation.parser.NotationParser;

import java.math.BigDecimal;

public abstract class Calculator {

    NotationCalculation calculation;
    NotationParser notationParser;
    FormulaParser formulaParser;

    public BigDecimal calculate(String formula) {
        return calculation.calculate(
                        notationParser.parseFrom(
                                formulaParser.parseFrom(formula)));
    }
}
