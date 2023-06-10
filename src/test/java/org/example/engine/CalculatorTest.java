package org.example.engine;

import org.example.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    Console console;
    Calculator calculator;

    @BeforeEach
    void setUp() {
        this.console = new Console();
        this.calculator = new Calculator(this.console);
    }

    @DisplayName("사칙연산 공백 전처리 테스트")
    @Test
    void preprocessExpressionTest() {
        String rowExpression = "   1     +     2   3  /    3    *   8  - 2   ";
        String preprocessedExpression = "1 + 23 / 3 * 8 - 2";
        assertEquals(preprocessedExpression,calculator.preprocess(rowExpression));
    }

    @DisplayName("사칙연산 입력 검증 통과 테스트")
    @ParameterizedTest
    @MethodSource("passValidateExpressionTestData")
    void passValidateExpressionTest(String expression){
        boolean expected = true;
        boolean actual = calculator.validateExpression(expression);
        assertEquals(expected, actual);


    }

    @DisplayName("사칙연산 입력 검증 실페 테스트")
    @ParameterizedTest
    @MethodSource("failValidateExpressionTestData")
    void failValidateExpressionTest(String expression){
        boolean expected = false;
        boolean actual = calculator.validateExpression(expression);
        assertEquals(expected, actual);

    }

    @DisplayName("문자열 형태의 연산 입력값을 공백을 기준으로 분리한 리스트 변환")
    @Test
    void parseExpressionTest(){
        String expression = "1 + 2 / 3 * 4 - 5";
        List<String> expected = Arrays.asList("1","+","2","/","3","*","4","-","5");
        List<String> actual = calculator.parseExpression(expression);
        assertEquals(expected, actual);

    }

    @DisplayName("연산자 우선순위를 반영하여 중위식 표현의 연산입력값을 후위식으로 표현")
    @ParameterizedTest
    @MethodSource("infixToPostfixTestData")
    void infixToPostfixTest(List<String> input, List<String> output){
        List<String> expected = output;
        List<String> actual = calculator.infixToPostfix(input);
        assertEquals(expected, actual);

    }

    @DisplayName("연산자 우선순위를 반영하여 중위식 표현의 연산입력값을 후위식으로 표현")
    @ParameterizedTest
    @MethodSource("caluateTestData")
    void calulateTest(List<String> postfixExpression, Double output){

        System.out.println(calculator.calculate(postfixExpression));
        Double expected = output;
        Double actual = calculator.calculate(postfixExpression);
        assertEquals(expected, actual);

    }

    @DisplayName("0으로 나눌시 예외 반환")
    @Test
    void calulateTest2(){

        List<String> postfixExpression = Arrays.asList("1","0","/");

        assertThrows(ArithmeticException.class, () -> {
            double result = calculator.calculate(postfixExpression);
        });

    }

    private static List<String> passValidateExpressionTestData() {
        return Arrays.asList(
            "1 + 2 / 3 * 4 - 5",
            "1    +     2     /   3   *   4   -   5",
            "1+2/3*4",
            "2222222222+33333333/4*777777-2"
        );
    }

    private static List<String> failValidateExpressionTestData() {
        return Arrays.asList(
                "1 + 2 / 3 * 4 -",
                "1 + +  2     /   3   *   4   -   5",
                "1+2/ 3 4",
                "     "
        );
    }

    private static Stream<Arguments> infixToPostfixTestData() {

            return Stream.of(
                    Arguments.of(Arrays.asList("1","+","2","*","3"), Arrays.asList("1","2","3","*","+")),
                    Arguments.of(Arrays.asList("1","-","2","/","3"), Arrays.asList("1","2","3","/","-")),
                    Arguments.of(Arrays.asList("1","+","2","-","3"), Arrays.asList("1","2","+","3","-")),
                    Arguments.of(Arrays.asList("1","/","2","*","3"), Arrays.asList("1","2","/","3","*"))
            );
    }

    private static Stream<Arguments> caluateTestData() {

        return Stream.of(
                Arguments.of(Arrays.asList("1","2","3","*","+"), 6.0),
                Arguments.of(Arrays.asList("1","2","3","/","-"), 1.6666666666666665),
                Arguments.of(Arrays.asList("1","2","+","3","-"), 6.0),
                Arguments.of(Arrays.asList("1","2","/","3","*"), 3.5)
        );
    }




}