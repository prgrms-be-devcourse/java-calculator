package programmers.calculator.processor.arithmetic;

import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {
  ADD("+", Precedence.ADDITIVE, (first, second) -> first + second),
  SUBTRACT("-", Precedence.ADDITIVE, (first, second) -> first - second),
  MULTIPLY("*", Precedence.MULTIPLICATIVE, (first, second) -> first * second),
  DIVIDE("/", Precedence.MULTIPLICATIVE, (first, second) -> {
    if (second == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
    return first / second;
  });

  private static final Map<String, Operator> SYMBOL_MAP = Map.of(
      "+", ADD,
      "-", SUBTRACT,
      "*", MULTIPLY,
      "/", DIVIDE
  );
  private final String symbol;
  private final Precedence precedence;
  private final BinaryOperator<Double> operation;

  Operator(String symbol, Precedence precedence, BinaryOperator<Double> operation) {
    this.symbol = symbol;
    this.precedence = precedence;
    this.operation = operation;
  }

  public static Operator of(String symbol) {
    return SYMBOL_MAP.get(symbol);
  }

  public String getSymbol() {
    return symbol;
  }

  public double operate(double first, double second) {
    return operation.apply(first, second);
  }

  public boolean isPreceding(Operator other) {
    return precedence.compareTo(other.precedence) > 0;
  }
}
