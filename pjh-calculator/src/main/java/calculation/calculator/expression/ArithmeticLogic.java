package calculation.calculator.expression;

import java.math.BigDecimal;

public interface ArithmeticLogic {

  int getPriority(String op);

  BigDecimal calculate(String operator, BigDecimal operandA, BigDecimal operandB);

  String getExpressionRegex();

  String getOperatorRegex();
}
