package org.programmers.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.java.calculation.Calculation;
import org.programmers.java.calculation.InfixToPostfixConverter;
import org.programmers.java.calculation.PostfixCalculation;

import java.util.Arrays;
import java.util.List;

public class CalculationTest {

     InfixToPostfixConverter infixToPostfixConverter = new InfixToPostfixConverter();
     PostfixCalculation postfixCalculation = new PostfixCalculation();

     @Test
     @DisplayName("중위 표기식 -> 후위 표기식 변경")
     void infixToPostfix(){
          // given
          String[] formulaList = {"3", "+", "5", "*", "10"};
          List<String> postfixExpect = Arrays.asList("3","5","10","*","+");

          // when
          List<String> postfix = infixToPostfixConverter.convert(formulaList);

          // then
          Assertions.assertEquals(postfixExpect, postfix);
     }

     @Test
     @DisplayName("후위 표기식으로 연산하기")
     void postfixCalculate(){
          // given
          List<String> postfix = Arrays.asList("3","5","10","*","+");

          // when
          String calculateValue = postfixCalculation.calculate(postfix);

          // then
          Assertions.assertEquals("53", calculateValue);
     }


}
