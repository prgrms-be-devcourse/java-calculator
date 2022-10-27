package com.programmers.java.engine;

import com.programmers.java.engine.calculator.CalculatorImpl;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorImplTest {

    private static CalculatorImpl calculatorImpl;

    @BeforeAll
    public static void init() {
        calculatorImpl = new CalculatorImpl();
    }

    @Test
    public void 식_토큰화_테스트() throws Exception {
        //given
//        String expression1 = "14 + 2.0 * 3.1 - 0.1 / 214";
//        String[] tokenizedExpression1 = {"14", "+", "2.0", "*", "3.1", "-", "0.1", "/", "214"};
//        String expression2 = "1 / 0";
//        String[] tokenizedExpression2 = {"1", "/", "0"};
        String str1 = "-1+-1";
        String str2 = "-12.2*-3.31";
        String str3 = "1+3--2+1";

        //when
        Expression resultExpression1 = calculatorImpl.parseExpression(str1);
        Expression resultExpression2 = calculatorImpl.parseExpression(str2);
        Expression resultExpression3 = calculatorImpl.parseExpression(str3);

        //then
        System.out.println(resultExpression1);
        System.out.println(resultExpression2);
        System.out.println(resultExpression3);
    }

    @Test
    public void 후위연산_변환_테스트() {
        //given
        String[] ex1 = {"14", "+", "2.0", "*", "3.1", "-", "0.1", "/", "214"};
        String[] ans1 = {"14", "2.0", "3.1", "*", "+", "0.1", "214", "/", "-"};
        String[] ex2 = {"3", "*", "-2", "-", "5"};
        String[] ans2 = {"3", "-2", "*", "5", "-"};

        //when
        String[] postfix1 = calculatorImpl.makePostfix(ex1);
        String[] postfix2 = calculatorImpl.makePostfix(ex2);

        //then
        System.out.println(Arrays.toString(postfix1));
        System.out.println(Arrays.toString(postfix2));
        assertArrayEquals(ans1, postfix1);
        assertArrayEquals(ans2, postfix2);
    }

    @Test
    public void 연산_테스트() {
        //given
        String[] ex1 = {"14", "2.0", "3.1", "*", "+", "10", "2", "/", "-"};
        String[] ex2 = {"3", "-2", "*", "5", "-"};
        Double ans1 = 15.2;
        Double ans2 = -11.0;

        //when
        Answer result1 = calculatorImpl.getResult(ex1);
        Answer result2 = calculatorImpl.getResult(ex2);

        //then
        System.out.println(result1.getValue());
        System.out.println(result2.getValue());
        assertEquals(ans1, result1.getValue());
        assertEquals(ans2, result2.getValue());
    }

    @Test
    public void 토큰화_테스트() {
        //given
        String str1 = "-1+-1";
        String str2 = "-12.2*-3.31";
        String str3 = "1+a-/2+1";

        //when
        String[] tokens1 = calculatorImpl.numberOperatorTokenizer(str1);
        String[] tokens2 = calculatorImpl.numberOperatorTokenizer(str2);
        String[] tokens3 = calculatorImpl.numberOperatorTokenizer(str3);


        //then
        System.out.println(Arrays.toString(tokens1));
        System.out.println(Arrays.toString(tokens2));
        System.out.println(Arrays.toString(tokens3));
    }

//    @Test
//    public void 세개_이상_연산자_테스트() throws TooManyOperatorException {
//        // given
//        String[] tokens1 = {"-", "-", "-"};
//        String[] tokens2 = {"-", "-", "1", "-", "-"};
//        String[] tokens3 = {"-", "1", "+", "-", "-"};
//
//        //when
//        calculatorImpl.validMoreThanTwoOperator(tokens2);
//        calculatorImpl.validMoreThanTwoOperator(tokens3);
//        calculatorImpl.validMoreThanTwoOperator(tokens1);
//    }

    @Test
    public void 잘못된_연산자_순서_테스트() throws Exception {
        //given
        String expression1 = "1+3-/2+1";
        String expression2 = "1-/1231+24";

        //when
        calculatorImpl.validWrongOrderOperator(expression1);
        calculatorImpl.validWrongOrderOperator(expression2);

        //then
    }
//
//    @Test
//    public void 빈_식_테스트() throws EmptyExpressionException {
//        //given
//        String expression1 = "";
//
//        //when
//        calculatorImpl.validEmptyExpression(expression1);
//
//        //then
//    }

//    @Test
//    public void 곱하기_나누기_연속_두번_테스트() throws DoubleMultiplyDivideException {
//        //given
//        String expression1 = "1//2";
//        String expression2 = "1++212";
//        String expression3 = "+1**212";
//
//        //when
//        calculatorImpl.validMultiplyDivideDouble(expression1);
//        calculatorImpl.validMultiplyDivideDouble(expression2);
//        calculatorImpl.validMultiplyDivideDouble(expression3);
//
//        //then
//    }

    @Test
    public void zero_division_테스트() {
        //given
        String expression1 = "-1+1/0+1/2";
        String expression2 = "-11/1";

        //when
        calculatorImpl.validZeroDivisionExpression(expression1);
        calculatorImpl.validZeroDivisionExpression(expression2);

        //then
    }
}