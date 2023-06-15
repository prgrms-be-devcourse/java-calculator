package com.programmers.engine.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  @DisplayName("더하기 성공")
  void 덧셈성공() {
    assertThat(Operator.ADD.calculate(1, 2)).isEqualTo(3);
  }

  @Test
  @DisplayName("빼기 성공")
  void 뺄셈성공() {
    assertThat(Operator.SUBTRACT.calculate(2, 1)).isEqualTo(1);
  }

  @Test
  @DisplayName("곱하기 성공")
  void 곱셈성공() {
    assertThat(Operator.MULTIPLY.calculate(3, 4)).isEqualTo(12);
  }

  @Test
  @DisplayName("나누기 성공")
  void 나눗셈성공() {
    assertThat(Operator.DIVIDE.calculate(1, 2)).isEqualTo(0.5);
  }
}
