package com.programmers.java.engine.calculator;

import com.programmers.java.application.config.TokenValidator;
import com.programmers.java.application.config.Validator;
import com.programmers.java.application.exception.*;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorImplTest {

    private static Calculator calculator;
    private static Validator validator = new TokenValidator();

    @BeforeAll
    public static void init() {
        calculator = new CalculatorImpl(validator);
    }

    @Nested
    public class 식_토큰화_테스트 {

        @Nested
        public class 식_토큰화_실패 {
            @Test
            public void zero_나누기() {
                //given
                String userInput = "1 / 0";

                //then
                assertThrows(ZeroDivisionException.class, () -> {
                    calculator.parseExpression(userInput);
                });
            }

            @Test
            public void 큰_숫자_사용() {
                //given
                String userInput = "2100000000 * 2";

                //then
                assertThrows(OutboundMaxValueException.class, () -> {
                    calculator.parseExpression(userInput);
                });
            }

            @Test
            public void 식_입력_안함() {
                //given
                String userInput = "";

                //then
                assertThrows(EmptyExpressionException.class, () -> {
                    calculator.parseExpression(userInput);
                });
            }

            @Test
            public void 숫자만_입력() {
                //given
                String userInput = "123.2";

                //then
                assertThrows(OnlyNumberException.class, () -> {
                    calculator.parseExpression(userInput);
                });
            }

            @Test
            public void 숫자_연산자_이외_사용() {
                //given
                String userInput = "123.2 + a";

                //then
                assertThrows(UnsupportedNumberOperatorException.class, () -> {
                    calculator.parseExpression(userInput);
                });
            }

            @Test
            public void 연산자_순서_잘못됨() {
                //given
                String userInput1 = "123.2 -* 1";
                String userInput2 = "123.2 -/ 1";
                String userInput3 = "123.2 +* 1";
                String userInput4 = "123.2 -/ 1";

                //then
                assertThrows(WrongUsedOperatorException.class, () -> {
                    calculator.parseExpression(userInput1);
                });
                assertThrows(WrongUsedOperatorException.class, () -> {
                    calculator.parseExpression(userInput2);
                });
                assertThrows(WrongUsedOperatorException.class, () -> {
                    calculator.parseExpression(userInput3);
                });
                assertThrows(WrongUsedOperatorException.class, () -> {
                    calculator.parseExpression(userInput4);
                });

            }
        }


        @Test
        public void 식_토큰화_성공() throws Exception {
            //given
            String userInput1 = "-1+-1";
            String userInput2 = "-12.2*-3.31";
            String userInput3 = "1 +3- - 2*1";
            String[] result1 = {"-1", "+", "-1"};
            String[] result2 = {"-12.2", "*", "-3.31"};
            String[] result3 = {"1", "+", "3", "-", "-2", "*", "1"};

            //when
            Expression resultExpression1 = calculator.parseExpression(userInput1);
            Expression resultExpression2 = calculator.parseExpression(userInput2);
            Expression resultExpression3 = calculator.parseExpression(userInput3);

            //then
            System.out.println(Arrays.toString(resultExpression1.getTokens()));
            System.out.println(Arrays.toString(resultExpression2.getTokens()));
            System.out.println(Arrays.toString(resultExpression3.getTokens()));
            assertArrayEquals(result1, resultExpression1.getTokens());
            assertArrayEquals(result2, resultExpression2.getTokens());
            assertArrayEquals(result3, resultExpression3.getTokens());
        }
    }

    @Nested
    public class 후위연산_변환_테스트 {
        @Test
        public void 후위연산_변환_성공() {
            //given
            String[] ex1 = {"14", "+", "2.0", "*", "3.1", "-", "0.1", "/", "214"};
            String[] ans1 = {"14", "2.0", "3.1", "*", "+", "0.1", "214", "/", "-"};
            String[] ex2 = {"-12.2", "*", "-3.31"};
            String[] ans2 = {"-12.2", "-3.31", "*"};

            //when
            String[] postfix1 = calculator.makePostfix(ex1);
            String[] postfix2 = calculator.makePostfix(ex2);

            //then
            System.out.println(Arrays.toString(postfix1));
            System.out.println(Arrays.toString(postfix2));
            assertArrayEquals(ans1, postfix1);
            assertArrayEquals(ans2, postfix2);
        }
    }



    @Test
    public void 연산_테스트() {
        //given
        String[] ex1 = {"14", "2.0", "3.1", "*", "+", "10", "2", "/", "-"};
        String[] ex2 = {"3", "-2", "*", "5", "-"};
        Double ans1 = 15.2;
        Double ans2 = -11.0;

        //when
        Answer result1 = calculator.calculate(ex1);
        Answer result2 = calculator.calculate(ex2);

        //then
        System.out.println(result1.getValue());
        System.out.println(result2.getValue());
        assertEquals(ans1, result1.getValue());
        assertEquals(ans2, result2.getValue());
    }

}