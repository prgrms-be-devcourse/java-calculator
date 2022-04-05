package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Validation;
import com.programmers.java.calculator.engine.model.Arithmetic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {
    private Validation validation;

    @BeforeEach
    public void setValidation() {
        validation = new Validation();
    }

    @DisplayName("null 또는 개행만 입력 될 경우 확인")
    @Test
    public void addNullAndEmptyString() {
        //given
        Arithmetic nullInput = validation.tokenize(null);
        Arithmetic nextLine = validation.tokenize("\n");

        //then
        assertThat(nullInput.getArithmetic()).isEmpty();
        assertThat(nextLine.getArithmetic()).isEmpty();
    }

    @DisplayName("공백이 한 칸이 아닐 경우 확인")
    @Test
    public void addMoreBlankSpace() {
        //given
        Arithmetic multiSpace = validation.tokenize("1     /      2\n");
        Arithmetic spaceInFront = validation.tokenize("  1 / 2\n");

        //then
        assertThat(multiSpace.getArithmetic()).isEmpty();
        assertThat(spaceInFront.getArithmetic()).isEmpty();
    }

    @DisplayName("올바른 입력 값 확인")
    @Test
    public void addTrueCase() {
        //given
        Arithmetic oneOperator = validation.tokenize("1 + 2");
        Arithmetic manyOperator = validation.tokenize("1 + 2 * 3 - 4");
        Arithmetic manyOperator2 = validation.tokenize("1 / 5 + 4 / 5");

        //then
        assertThat(oneOperator.getArithmetic()).isNotEmpty();
        assertThat(manyOperator.getArithmetic()).isNotEmpty();
        assertThat(manyOperator2.getArithmetic()).isNotEmpty();
    }

    @DisplayName("음수 값 입력 확인")
    @Test
    public void addNegativeCase() {
        //given
        Arithmetic negativeFront = validation.tokenize("-1 + 2");
        Arithmetic negativeBack = validation.tokenize("1 + 2 * 3 - -4");
        Arithmetic manyNegative = validation.tokenize("-1 - -5 - -4 - -5");

        //then
        assertThat(negativeFront.getArithmetic()).isNotEmpty();
        assertThat(negativeBack.getArithmetic()).isNotEmpty();
        assertThat(manyNegative.getArithmetic()).isNotEmpty();
    }

    @DisplayName("잘못된 입력값 확인")
    @Test
    public void addWrongString() {
        //given
        Arithmetic alphabet = validation.tokenize("A + B - c");
        Arithmetic special = validation.tokenize("3 * 5 % 6 ^ 7 # 1 @ 3");

        //then
        assertThat(alphabet.getArithmetic()).isEmpty();
        assertThat(special.getArithmetic()).isEmpty();
    }

    @DisplayName("잘못된 연산자 순서 확인")
    @Test
    public void checkOrderOperand() {
        //given
        Arithmetic endWithOperand = validation.tokenize("1 + 3 - 4 *");
        Arithmetic startWithOperand = validation.tokenize("* 3 + 2 - 4");
        Arithmetic onlyOperand = validation.tokenize("+ - * / + - *");

        //then
        assertThat(endWithOperand.getArithmetic()).isEmpty();
        assertThat(startWithOperand.getArithmetic()).isEmpty();
        assertThat(onlyOperand.getArithmetic()).isEmpty();
    }

    @DisplayName("잘못된 숫자 순서 확인")
    @Test
    public void checkOrderNumber() {
        //given
        Arithmetic startWithDoubleNumber = validation.tokenize("1 3 - 4 * 2");
        Arithmetic endWithDoubleNumber = validation.tokenize("1 * 3 + 2 - 4 3");
        Arithmetic onlyNumber = validation.tokenize("1 3 6 2 4 7 9");

        //then
        assertThat(startWithDoubleNumber.getArithmetic()).isEmpty();
        assertThat(endWithDoubleNumber.getArithmetic()).isEmpty();
        assertThat(onlyNumber.getArithmetic()).isEmpty();
    }

    @DisplayName("공백 없는 입력 값 확인")
    @Test
    public void noSpace() {
        //given
        Arithmetic noSpace = validation.tokenize("1+3-2*4");
        Arithmetic noSpaceNegative = validation.tokenize("-3-5-6");

        //then
        assertThat(noSpace.getArithmetic()).isEmpty();
        assertThat(noSpaceNegative.getArithmetic()).isEmpty();
    }
}
