package calculator.engine.calculator;

import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;

public interface ArithmeticCalculator {

    CalculationResult calculate(Expression postfix);
}
