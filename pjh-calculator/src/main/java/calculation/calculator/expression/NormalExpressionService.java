package calculation.calculator.expression;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NormalExpressionService implements ExpressionService {

  private final ArithmeticLogic logic;

  public NormalExpressionService(ArithmeticLogic logic) {
    this.logic = logic;
  }

  public List<String> parse(String exp) {
    return Arrays.stream(exp.split(" ")).collect(Collectors.toList());
  }

  public boolean checkExpression(String exp) {
    return Pattern.matches(logic.getExpressionRegex(), exp);
  }

  public List<String> convertToPostfix(List<String> exp) {
    List<String> tokenList = new ArrayList<>();
    Stack<String> stk = new Stack<>();
    for (int i = 0; i < exp.size(); i++) {
      String token = exp.get(i);
      if ((i % 2 == 0)) {
        tokenList.add(token);
      } else {
        while (!stk.isEmpty() && (logic.getPriority(stk.peek()) >= logic.getPriority(token))) {
          tokenList.add(stk.pop());
        }
        stk.push(token);
      }
    }
    while (!stk.isEmpty()) {
      tokenList.add(stk.pop());
    }
    return tokenList;
  }

  public boolean isOperator(String token) {
    return Pattern.matches(logic.getOperatorRegex(), token);
  }

  public BigDecimal calculate(String token, BigDecimal operandA, BigDecimal operandB) {
    return logic.calculate(token, operandA, operandB);
  }
}
