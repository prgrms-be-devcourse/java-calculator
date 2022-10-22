package calculator.calculator;

import calculator.calculator.formula.FormulaBasicParser;
import calculator.calculator.notation.calculation.NotationPostfixCalculation;
import calculator.calculator.notation.parser.NotationPostfixParser;

public class PostfixCalculator extends Calculator {

    public PostfixCalculator() {
        calculation = new NotationPostfixCalculation();
        notationParser = new NotationPostfixParser();
        formulaParser = new FormulaBasicParser();
    }
}
