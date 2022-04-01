package com.programmers.devcourse.processor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.programmers.devcourse.exception.processor.WrongOperatorTokenException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

  @DisplayName("from 메서드에 적합하지 않은 문자가 들어가면 WrongOperatorTokenException을 던져야 한다.")
  @ParameterizedTest
  @ValueSource(chars = {'a', 'b', '%', '3', '='})
  void fromMethodThrowWrongOperatorTokenException(char candidate) throws Exception {
    assertThatExceptionOfType(WrongOperatorTokenException.class).isThrownBy(() -> {
      Operator.from(candidate);
    });
  }

  @DisplayName("각 Operator 상수들은 operate를 통해 적합한 연산을 수행해야 한다.")
  @ParameterizedTest
  @CsvSource({"1 , 2", "3 , 5", "5 , 20", "5.4 , 6.7"})
  void operate(double n1, double n2) {
    assertThat(Operator.ADDITION.operate(n1, n2)).isEqualTo(Double.sum(n1, n2));
    assertThat(Operator.SUBTRACTION.operate(n1, n2)).isEqualTo(n1 - n2);
    assertThat(Operator.DIVISION.operate(n1, n2)).isEqualTo(n1 / n2);
    assertThat(Operator.MULTIPLICATION.operate(n1, n2)).isEqualTo(n1 * n2);
  }
}