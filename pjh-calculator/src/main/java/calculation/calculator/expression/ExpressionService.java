package calculation.calculator.expression;

import java.math.BigDecimal;
import java.util.List;

public interface ExpressionService {

  List<String> parse(String exp);

  boolean checkExpression(String exp);

  List<String> convertToPostfix(List<String> exp);

  boolean isOperator(String token);

  BigDecimal calculate(String token, BigDecimal operandA, BigDecimal operandB);
}
