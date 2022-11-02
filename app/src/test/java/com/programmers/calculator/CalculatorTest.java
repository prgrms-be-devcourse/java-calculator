package com.programmers.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사칙연산 테스트")
public class CalculatorTest {

  private final Calculator calculator = new Calculator();

  @DisplayName("덧셈 테스트")
  @Test
  void add() {
    //given
    String form = "10 + 5";
    //when
    Double answer = calculator.getAnswer(form);
    //then
    assertEquals(15.0, answer);
  }

  @DisplayName("뺄셈 테스트")
  @Test
  void subject() {
    //given
    String form = "10 - 5";
    //when
    Double answer = calculator.getAnswer(form);
    //then
    assertEquals(5.0, answer);
  }

  @DisplayName("곱셈 테스트")
  @Test
  void multi() {
    //given
    String form = "10 * 5";
    //when
    Double answer = calculator.getAnswer(form);
    //then
    assertEquals(50.0, answer);
  }

  @DisplayName("나눗셈 테스트")
  @Test
  void division() {
    //given
    String form = "10 / 5";
    //when
    Double answer = calculator.getAnswer(form);
    //then
    assertEquals(2.0, answer);
  }

  @DisplayName("나눗셈 실패 테스트")
  @Test
  void failDivision() {
    //given
    String form = "10 / 0";
    //when & then
    assertThrows(ArithmeticException.class, () -> calculator.getAnswer(form), "0으로는 나눌 수 없습니다.");
  }


}
