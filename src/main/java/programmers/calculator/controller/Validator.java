package programmers.calculator.controller;

import static lombok.AccessLevel.PRIVATE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.NoArgsConstructor;
import programmers.calculator.processor.arithmetic.Operator;
import programmers.calculator.util.PatternUtil;

@NoArgsConstructor(access = PRIVATE)
public class Validator {

  public static void validate(List<String> tokens) {
    List<String> numerics = new ArrayList<>();
    List<String> operators = new ArrayList<>();
    IntStream.range(0, tokens.size()).filter(i -> i % 2 == 0)
        .forEach(i -> numerics.add(tokens.get(i)));
    IntStream.range(0, tokens.size()).filter(i -> i % 2 == 1)
        .forEach(i -> operators.add(tokens.get(i)));

    validateNumeric(numerics);
    validateOperator(operators);
    validateMatch(numerics, operators);
  }

  private static void validateNumeric(List<String> tokens) {
    tokens.stream().filter(token -> !PatternUtil.isNumeric(token)).findAny().ifPresent(
        (t) -> {
          throw new IllegalArgumentException("잘못된 수식입니다.");
        });
  }

  private static void validateOperator(List<String> tokens) {
    tokens.stream().filter(token -> !Operator.isOperator(token)).findAny().ifPresent(
        (t) -> {
          throw new IllegalArgumentException("잘못된 수식입니다.");
        });
  }

  private static void validateMatch(List<String> numerics, List<String> operators) {
    if (numerics.size() == operators.size() + 1) {
      return;
    }
    throw new IllegalArgumentException("잘못된 수식입니다.");
  }

}
