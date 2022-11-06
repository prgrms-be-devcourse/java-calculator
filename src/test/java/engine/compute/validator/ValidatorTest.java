package engine.compute.validator;

import engine.exception.NotValidInputException;
import engine.model.Token;
import engine.compute.converter.ExpressionConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ValidatorTest {
    private ExpressionValidator validator;
    private ExpressionConverter converter;

    @BeforeEach
    void setting() {
        validator = new SimpleExpressionValidator();
        converter = new ExpressionConverter(validator);
    }

    @Test
    void 입력값이숫자인지검증() {
        Assertions.assertEquals(validator.isNumber(new Token("3.14")), true);
        Assertions.assertEquals(validator.isNumber(new Token("314")), true);
        Assertions.assertEquals(validator.isNumber(new Token("0.14")), true);
        Assertions.assertEquals(validator.isNumber(new Token("hello")), false);
    }

    @Test
    void isPlusOperatorTest() {
        Assertions.assertEquals(validator.isOperator(new Token("+")), true);
    }

    @Test
    void isMinusOperatorTest() {
        Assertions.assertEquals(validator.isOperator(new Token("-")), true);
    }

    @Test
    void isMultiplyOperatorTest() {
        Assertions.assertEquals(validator.isOperator(new Token("/")), true);
    }

    @Test
    void isDivideOperatorTest() {
        Assertions.assertEquals(validator.isOperator(new Token("*")), true);
    }

    @Test
    void isWrongOperatorTest() {
        Assertions.assertEquals(validator.isOperator(new Token("1")), false);
        Assertions.assertEquals(validator.isOperator(new Token("a")), false);
        Assertions.assertEquals(validator.isOperator(new Token("0")), false);
        Assertions.assertEquals(validator.isOperator(new Token("&")), false);
    }

    @Test
    void 연산식순서검증테스트1() {
        //given
        String expression = "3+5";
        List<Token> tokens;

        //when
        tokens = converter.convertUserInputToTokenList(expression);

        //then
        Assertions.assertEquals(validator.isCorrectOrder(tokens), true);
    }
    @Test
    void 연산식순서검증테스트2() {
        //given
        String expression = "3+5 * 4 / 2";
        List<Token> tokens;

        //when
        tokens = converter.convertUserInputToTokenList(expression);

        //then
        Assertions.assertEquals(validator.isCorrectOrder(tokens), true);
    }
    @Test
    void 연산식순서검증테스트3() {
        //given
        String expression = "35+";
        List<Token> tokens;

        //when
        tokens = converter.convertUserInputToTokenList(expression);

        //then
        Assertions.assertEquals(validator.isCorrectOrder(tokens), false);
    }

    @Test
    void 연산식순서검증테스트4() {
        //given
        String expression = "++35";
        List<Token> tokens;

        //when
        tokens = converter.convertUserInputToTokenList(expression);

        //then
        Assertions.assertEquals(validator.isCorrectOrder(tokens), false);
    }
    @Test
    void 연산식순서검증테스트5() {
        //given
        String expression = "3++5 * 4 / 2";
        List<Token> tokens;

        //when
        tokens = converter.convertUserInputToTokenList(expression);

        //then
        Assertions.assertEquals(validator.isCorrectOrder(tokens), false);
    }

    @Test
    void 잘못된연산식테스트1() {
        //given
        String expression = "35+";
        List<Token> tokens = converter.convertUserInputToTokenList(expression);

        Assertions.assertThrowsExactly(NotValidInputException.class,
                () -> validator.getValidatedTokenList(tokens));
    }

    @Test
    void 잘못된연산식테스트2() {
        //given
        String expression = "3++5 * 4 / 2 +";
        List<Token> tokens = converter.convertUserInputToTokenList(expression);

        Assertions.assertThrowsExactly(NotValidInputException.class,
                () -> validator.getValidatedTokenList(tokens));
    }
}