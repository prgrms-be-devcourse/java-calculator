package org.programmers.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.programmers.java.calculation.Calculation;
import org.programmers.java.calculation.InfixToPostfixConverter;
import org.programmers.java.calculation.Operator;
import org.programmers.java.calculation.PostfixCalculation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculationTest {

     InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
     PostfixCalculation postfixCalculation = new PostfixCalculation();

     @ParameterizedTest
     @DisplayName("중위 표기식 -> 후위 표기식")
     @MethodSource("makeFormulaAndPostfix")
     void infixToPostfix(List<String> expectPostfix, String[] formula){
          // when
          List<String> postfix = infixToPostfixConverter.convert(formula);

          // then
          assertEquals(expectPostfix, postfix);
     }

     static Stream<Arguments> makeFormulaAndPostfix() {
          return Stream.of(
                  Arguments.of(Arrays.asList("3", "5", "10", "*", "+"), new String[]{"3","+","5","*","10"}),
                  Arguments.of(Arrays.asList("3", "5", "10", "-", "+"), new String[]{"3","+","5","-","10"}),
                  Arguments.of(Arrays.asList("3", "10", "5", "/", "+"), new String[]{"3","+","10","/","5"})
          );
     }

     @ParameterizedTest
     @DisplayName("후위 표기식으로 연산하기")
     @MethodSource("makePostfixList")
     void postfixCalculate(List<String> postfix, String result) {
          // when
          String calculateValue = postfixCalculation.calculate(postfix);

          // then
          assertEquals(result, calculateValue);
     }

     static Stream<Arguments> makePostfixList() {
          return Stream.of(
                  Arguments.of(Arrays.asList("3", "5", "10", "*", "+"), "53"),
                  Arguments.of(Arrays.asList("3", "5", "10", "-", "+"), "-2"),
                  Arguments.of(Arrays.asList("3", "10", "5", "/", "+"), "5")
          );
     }

     @Test
     @DisplayName("0으로 나눌 때 예외가 발생")
     void checkZeroDivide() {
          // given
          String operator = "/";

          // when, then
          assertThrows(IllegalArgumentException.class, () -> Operator.checkDivideZero(operator,0));
     }
}
