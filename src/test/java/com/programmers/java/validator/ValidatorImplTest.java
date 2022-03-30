package com.programmers.java.validator;

import com.programmers.java.enums.ErrorMessage;
import com.programmers.java.tokenizer.Tokenizer;
import com.programmers.java.tokenizer.TokenizerImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorImplTest {

    Tokenizer tokenizer;
    Validator validator;

    @BeforeEach
    void beforeEach() {
        tokenizer = new TokenizerImpl();
        validator = new ValidatorImpl(tokenizer);
    }

    @Test
    void 계산식_널값_검증_테스트() {
        //given
        String formula1 = "";
        String formula2 = " ";
        String formula3 = "    ";

        //when
        Exception e1 = assertThrows(NullPointerException.class, ()-> validator.validateNull(formula1));
        Exception e2 = assertThrows(NullPointerException.class, ()-> validator.validateNull(formula2));
        Exception e3 = assertThrows(NullPointerException.class, ()-> validator.validateNull(formula3));

        //then
        assertThat(e1.getMessage()).isEqualTo(ErrorMessage.EMPTY_INPUT.getMessage());
        assertThat(e2.getMessage()).isEqualTo(ErrorMessage.EMPTY_INPUT.getMessage());
        assertThat(e3.getMessage()).isEqualTo(ErrorMessage.EMPTY_INPUT.getMessage());

    }

    @Test
    @DisplayName("문자 하나만 계산식으로 입력되면 예외 처리해야 한다.")
    void 계산식_길이_검증_테스트1() {
        //given
        String formula = "1";
        List<String> formulaList = tokenizer.tokenizeFormula(formula);

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validateLength(formulaList));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_FORMULA.getMessage());
    }

    @Test
    @DisplayName("입력된 계산식 내 문자의 갯수는 짝수여야 한다.")
    void 계산식_길이_검증_테스트2() {
        //given
        String formula = "1 * 2 +";
        List<String> formulaList = tokenizer.tokenizeFormula(formula);

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validateLength(formulaList));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_FORMULA.getMessage());
    }

    @Test
    @DisplayName("입력된 계산식의 연산자와 피연산자가 번갈아가면서 나와야한다.")
    void 계산식_순서_검증_테스트() {
        //given
        String formula = "1 * -10 + 5 / + * 5";
        List<String> formulaList = tokenizer.tokenizeFormula(formula);

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validateOrder(formulaList));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_OPERAND.getMessage());
    }

    @Test
    void 계산식_0으로_나누기_실패_검증_테스트() {
        //given
        String formula = "1 * 10 / 0";
        List<String> formulaList = tokenizer.tokenizeFormula(formula);

        //when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validateDivideZero(formulaList));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_DIVIDE_ZERO.getMessage());
    }
}