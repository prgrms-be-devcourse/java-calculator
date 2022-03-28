package calculation.calculator.engine;

import calculation.calculator.expression.NormalExpressionService;
import calculation.model.CalcData;
import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class BigDecimalCalculator {

  private final NormalExpressionService expService;

  public BigDecimalCalculator(NormalExpressionService expService) {
    this.expService = expService;
  }

  public CalcData execute(String exp) {
    if (!expService.checkExpression(exp)) {
      throw new IllegalArgumentException("잘못된 연산식 입니다.");
    }
    List<String> parse = expService.parse(exp);
    List<String> expression = expService.convertToPostfix(parse);
    Stack<BigDecimal> stk = new Stack<>();
    for (int i = 0; i < expression.size(); i++) {
      String token = expression.get(i);
      if (stk.size() >= 2 && expService.isOperator(token)) {
        BigDecimal numB = stk.pop();
        BigDecimal numA = stk.pop();
        stk.push(expService.calculate(token, numA, numB));
      } else {
        stk.push(new BigDecimal(token));
      }
    }
    return new CalcData(exp, stk.pop());
  }
}
