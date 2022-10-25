package com.programmers.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculationTest {

  Calculation calculation = new Calculation(new FourArithmeticImpl());

  @Test
  @DisplayName("덧셈 테스트")
  void addTest() {
    //given
    String input = "2 + 3 + 4";
    List<String> formArray = calculation.toList(input.split(" "));

    //when
    String answer = calculation.calculate(formArray);

    //then
    assertEquals("9.0", answer);
  }

  @Test
  @DisplayName("뺄셈 테스트")
  void subjectTest() {
    //given
    String input = "10 - 2 - 3";
    List<String> formArray = calculation.toList(input.split(" "));

    //when
    String answer = calculation.calculate(formArray);

    //then
    assertEquals("5.0", answer);

  }


  @Test
  @DisplayName("곱셈 테스트")
  void multiTest() {
    //given
    String input = "1 * 2 * 3";
    List<String> formArray = calculation.toList(input.split(" "));

    //when
    String answer = calculation.calculate(formArray);

    //then
    assertEquals("6.0", answer);
  }

  @Test
  @DisplayName("나눗셈 테스트")
  void divisionTest() {
    //given
    String input = "10 / 2";
    List<String> formArray = calculation.toList(input.split(" "));

    //when
    String answer = calculation.calculate(formArray);

    //then
    assertEquals("5.0", answer);
  }

  @Test
  @DisplayName("나눗셈 실패 테스트")
  void divideByZeroTest() {
    //given
    String input = "10 / 0";
    List<String> formArray = calculation.toList(input.split(" "));

    //when
    String answer = calculation.calculate(formArray);

    //then
    assertEquals("0으로는 나눌 수 없습니다", answer);
  }



}
