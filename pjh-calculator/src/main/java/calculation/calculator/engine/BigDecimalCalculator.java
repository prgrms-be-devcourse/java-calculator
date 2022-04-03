package calculation.calculator.engine;

import calculation.calculator.expression.NormalExpressionService;
import calculation.model.CalculationData;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BigDecimalCalculator {

  private final NormalExpressionService expService;

  public BigDecimalCalculator(NormalExpressionService expService) {
    this.expService = expService;
  }

  public CalculationData execute(String exp) {
    if (!expService.checkExpression(exp)) {
      throw new IllegalArgumentException("잘못된 연산식 입니다.");
    }
    List<String> parse = expService.parse(exp);
    List<String> expression = expService.convertToPostfix(parse);
    Deque<BigDecimal> stack = new ArrayDeque<>();
    expression.stream().forEach((token)-> push(stack,token));
    return new CalculationData(exp, stack.pop());
  }

  private void push(Deque<BigDecimal> stack, String token)
  {
    if (stack.size() >= 2 && expService.isOperator(token)) {
      BigDecimal numB = stack.pop();
      BigDecimal numA = stack.pop();
      stack.push(expService.calculate(token, numA, numB));
    } else {
      stack.push(new BigDecimal(token));
    }
  }
}
