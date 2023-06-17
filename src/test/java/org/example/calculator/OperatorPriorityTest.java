package org.example.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperatorPriorityTest {

  @Test
  @DisplayName("연산자 판별 테스트")
  void isOperator() {
    Assertions.assertThat(OperatorPriority.isOperator("+")).isEqualTo(true);
    Assertions.assertThat(OperatorPriority.isOperator("/")).isEqualTo(true);
  }

  @Test
  @DisplayName("연산자 판별 실패 테스트")
  void isNotOperator() {
    Assertions.assertThat(OperatorPriority.isOperator("2")).isEqualTo(true);
    Assertions.assertThat(OperatorPriority.isOperator("&")).isEqualTo(true);
  }
}
