package com.prgrms.dev;

import org.junit.jupiter.api.*;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SimpleOperatorTest {

  SimpleOperator simpleOperator = new SimpleOperator();

  @Test
  @Order(1)
  void 덧셈() throws Exception {
    String[] array = {"1", "+", "2"};
    int expected = 3;

    Method method = simpleOperator.getClass().getDeclaredMethod("calculate", String[].class);
    method.setAccessible(true);

    int result = (int) method.invoke(simpleOperator, new Object[] {array});
    assertEquals(result, expected);
  }

  @Test @Order(2)
  void 뺄셈() throws Exception {
    String[] array = {"1", "-", "2"};
    int expected = -1;

    Method method = simpleOperator.getClass().getDeclaredMethod("calculate", String[].class);
    method.setAccessible(true);

    int result = (int) method.invoke(simpleOperator, new Object[] {array});
    assertEquals(result, expected);
  }
  @Test @Order(3)
  void 곱셈() throws Exception {
    String[] array = {"2", "*", "2"};
    int expected = 4;

    Method method = simpleOperator.getClass().getDeclaredMethod("calculate", String[].class);
    method.setAccessible(true);

    int result = (int) method.invoke(simpleOperator, new Object[] {array});
    assertEquals(result, expected);
  }

  @Test @Order(4)
  void 나눗셈() throws Exception {
    String[] array = {"8", "/", "4"};
    int expected = 2;

    Method method = simpleOperator.getClass().getDeclaredMethod("calculate", String[].class);
    method.setAccessible(true);

    int result = (int) method.invoke(simpleOperator, new Object[] {array});
    assertEquals(result, expected);
  }

  @Test @Order(5)
  @DisplayName("우선순위(*, /) 먼저 계산하기")
  void calculatePriority() throws Exception {
    Method method = simpleOperator.getClass().getDeclaredMethod("calculatePriority", String.class);
    method.setAccessible(true);

    // given
    String formula = "3 * 2 + 4 / 2 * 2";
    String expected = "6 + 4";

    // when
    String result = String.valueOf(method.invoke(simpleOperator, formula));

    // then
    assertEquals(result, expected);
  }

  @Test @Order(6)
  void 우선순위_계산() {
    // given
    String formula = "3 * 2 + 4 / 2 * 2";
    int expected = 10;

    // when
    int result = simpleOperator.calculate(formula);

    // then
    assertEquals(result, expected);
  }
}