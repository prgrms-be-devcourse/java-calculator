package com.programmers.java.engin;

import com.programmers.java.engin.io.Calculation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class postfixCalculationTest {

//    private static Calculation calculation = new PostfixCalculation();
//
//    // 1. 잘못된 표현의 input 테스트
//    @DisplayName("숫자와 사칙연산자만 제외한 문자 입력 테스트")
//    @Test
//    void CalculatorOtherInput(){
//        final String input = "4 % 7";
//        Optional<String> result = calculation.getResult(input);
//        assertSame(Optional.empty(),result);
//    }
//
//    @DisplayName("연산자와 숫자 사이의 공백이 포함되지않은 입력 테스트")
//    @Test
//    void CalculatorNonSpaceInput(){
//        final String input = "7+3-1";
//        Optional<String> result = calculation.getResult(input);
//        assertSame(Optional.empty(),result);
//    }
//
//    @DisplayName("피연사자 자연수가 아닌 입력 테스트")
//    @Test
//    void CalculatorNonNatualNumInput(){
//        final String input = "2.2 + 7";
//        Optional<String> result = calculation.getResult(input);
//        assertSame(Optional.empty(),result);
//    }
//
//    // 2. 계산 결과 테스트
//    @DisplayName("올바른 계산 - 연산자 우선순위 미포함")
//    @Test
//    void CalculatorBasicOperator(){
//        final String input = "7 * 20 - 9";
//        Optional<String> result = calculation.getResult(input);
//        assertEquals("131",result.get());
//    }
//
//    @DisplayName("올바른 계산 - 연산자 우선순위 포함")
//    @Test
//    void CalculatorOrderOfOperator(){
//        final String input = "82 + 2 * 4";
//        Optional<String> result = calculation.getResult(input);
//        assertEquals("90",result.get());
//    }

}