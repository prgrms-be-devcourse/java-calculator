package com.programmers.java.engin.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.DecimalFormat;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    DecimalFormat resultBuffer = new DecimalFormat("#.##");

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("calculateParameters")
    @DisplayName("사칙연산 계산")
    void calculate(String name, double num1, double num2, String operator, String result) {
        assertEquals(resultBuffer.format(Operator.of(operator).result(num1,num2)),result);
    }

    private static Stream<Arguments> calculateParameters() {
        return Stream.of(
                Arguments.of("더하기",1,2,"+","3"),
                Arguments.of("빼기",3,5,"-","-2"),
                Arguments.of("곱하기",77,3,"*","231"),
                Arguments.of("나누기",2,7,"/","0.29")
        );
    }

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("validParameters")
    @DisplayName("연산자 유효성 검사")
    void validOperator(double num1, double num2, String operator, String errMsg){
        Exception error = assertThrows(Exception.class,()-> Operator.of(operator));
        assertEquals(error.getMessage(),errMsg);
    }

    private static Stream<Arguments> validParameters(){
        return Stream.of(
                Arguments.of(1,2,"%","잘못된 연산식 입니다."),
                Arguments.of(3,5,"dd","잘못된 연산식 입니다."),
                Arguments.of(77,3,"&","잘못된 연산식 입니다.")
        );
    }

}