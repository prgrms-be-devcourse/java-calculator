package com.prgrms.dev;

import org.junit.jupiter.api.*;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostfixOperatorTest {

  PostfixOperator postfixOperator = new PostfixOperator();

  @Test @Order(1)
  void 덧셈() throws Exception {
    int a = 1;
    int b = 2;
    char operator = '+';
    int expected = 3;

    Method method = postfixOperator.getClass().getDeclaredMethod("calculate", int.class, int.class, char.class);
    method.setAccessible(true);

    int result = (int) method.invoke(postfixOperator, a, b, operator);
    assertEquals(result, expected);
  }

  @Test @Order(2)
  void 뺄셈() throws Exception {
    int a = 1;
    int b = 2;
    char operator = '-';
    int expected = -1;

    Method method = postfixOperator.getClass().getDeclaredMethod("calculate", int.class, int.class, char.class);
    method.setAccessible(true);

    int result = (int) method.invoke(postfixOperator, a, b, operator);
    assertEquals(result, expected);
  }
  @Test @Order(3)
  void 곱셈() throws Exception {
    int a = 2;
    int b = 2;
    char operator = '+';
    int expected = 4;

    Method method = postfixOperator.getClass().getDeclaredMethod("calculate", int.class, int.class, char.class);
    method.setAccessible(true);

    int result = (int) method.invoke(postfixOperator, a, b, operator);
    assertEquals(result, expected);
  }

  @Test @Order(4)
  void 나눗셈() throws Exception {
    int a = 8;
    int b = 4;
    char operator = '/';
    int expected = 2;

    Method method = postfixOperator.getClass().getDeclaredMethod("calculate", int.class, int.class, char.class);
    method.setAccessible(true);

    int result = (int) method.invoke(postfixOperator, a, b, operator);
    assertEquals(result, expected);
  }

  @Test @Order(5)
  void 후위식_변환() throws Exception {
    // given
    String formula = "3 * 2 + 4 / 2 * 2";
    String expected = "32*42/2*+";

    Method method = postfixOperator.getClass().getDeclaredMethod("convertPostFix", String.class);
    method.setAccessible(true);

    // when
    String result = String.valueOf(method.invoke(postfixOperator, formula));

    // then
    assertEquals(result, expected);
  }

  @Test @Order(6)
  void 우선순위_계산() {
    // given
    String formula = "3 * 2 + 4 / 2 * 2";
    int expected = 10;

    // when
    int result = postfixOperator.calculate(formula);

    // then
    assertEquals(result, expected);
  }
}