package org.programmers.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class calculateTest {


    Calculate calculate = new Calculate();



    @Test
    void postfixCalculate() {
        // given
        List<String> postfix = Arrays.asList("5", "8", "3", "*", "+");

        // when
        String calculateValue = calculate.calculatePostfix(postfix);

        // then
        double expectedResult = 29.0;
        double actualResult = Double.parseDouble(calculateValue);
        Assertions.assertEquals(expectedResult, actualResult, 0.0001);
    }


    @Test
    void infixToPostfix(){
        // given
        String[] formulaList = {"3", "+", "5", "*", "10"};
        List<String> postfixExpect = Arrays.asList("3","5","10","*","+");

        // when
        List<String> postfix = calculate.convertToPostfix(formulaList);

        // then
        Assertions.assertEquals(postfixExpect, postfix);
    }


    @Test
    void calculatePostfix_SubtractionAndDivision() {
        // given
        List<String> postfix = Arrays.asList("10", "4", "2", "-", "/");

        // when
        String calculateValue = calculate.calculatePostfix(postfix);

        // then
        double expectedResult = 5.0;
        double actualResult = Double.parseDouble(calculateValue);
        Assertions.assertEquals(expectedResult, actualResult, 0.0001);
    }
}







