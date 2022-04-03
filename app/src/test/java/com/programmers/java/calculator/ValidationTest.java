package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Validation;
import com.programmers.java.calculator.engine.model.Arithmetic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
        Optional<Arithmetic> nullInput = validation.checkValid(null);
        Optional<Arithmetic> nextLine = validation.checkValid("\n");

        //then
        assertThat(nullInput).isEmpty();
        assertThat(nextLine).isEmpty();
    }

    @DisplayName("공백이 한 칸이 아닐 경우 확인")
    @Test
    public void addMoreBlankSpace() {
        //given
        Optional<Arithmetic> multiSpace = validation.checkValid("1     /      2\n");
        Optional<Arithmetic> spaceInFront = validation.checkValid("  1 / 2\n");

        //then
        assertThat(multiSpace).isEmpty();
        assertThat(spaceInFront).isEmpty();
    }

    @DisplayName("올바른 입력 값 확인")
    @Test
    public void addTrueCase() {
        //given
        Optional<Arithmetic> oneOperator = validation.checkValid("1 + 2");
        Optional<Arithmetic> manyOperator = validation.checkValid("1 + 2 * 3 - 4");
        Optional<Arithmetic> manyOperator2 = validation.checkValid("1 / 5 + 4 / 5");

        //then
        assertThat(oneOperator).isNotEmpty();
        assertThat(manyOperator).isNotEmpty();
        assertThat(manyOperator2).isNotEmpty();
    }

    @DisplayName("음수 값 입력 확인")
    @Test
    public void addNegativeCase() {
        //given
        Optional<Arithmetic> negativeFront = validation.checkValid("-1 + 2");
        Optional<Arithmetic> negativeBack = validation.checkValid("1 + 2 * 3 - -4");
        Optional<Arithmetic> manyNegative = validation.checkValid("-1 - -5 - -4 - -5");

        //then
        assertThat(negativeFront).isNotEmpty();
        assertThat(negativeBack).isNotEmpty();
        assertThat(manyNegative).isNotEmpty();
    }

    @DisplayName("잘못된 입력값 확인")
    @Test
    public void addWrongString() {
        //given
        Optional<Arithmetic> alphabet = validation.checkValid("A + B - c");
        Optional<Arithmetic> special = validation.checkValid("3 * 5 % 6 ^ 7 # 1 @ 3");

        //then
        assertThat(alphabet).isEmpty();
        assertThat(special).isEmpty();
    }

    @DisplayName("잘못된 연산자 순서 확인")
    @Test
    public void checkOrderOperand() {
        //given
        Optional<Arithmetic> endWithOperand = validation.checkValid("1 + 3 - 4 *");
        Optional<Arithmetic> startWithOperand = validation.checkValid("* 3 + 2 - 4");
        Optional<Arithmetic> onlyOperand = validation.checkValid("+ - * / + - *");

        //then
        assertThat(endWithOperand).isEmpty();
        assertThat(startWithOperand).isEmpty();
        assertThat(onlyOperand).isEmpty();
    }

    @DisplayName("잘못된 숫자 순서 확인")
    @Test
    public void checkOrderNumber() {
        //given
        Optional<Arithmetic> startWithDoubleNumber = validation.checkValid("1 3 - 4 * 2");
        Optional<Arithmetic> endWithDoubleNumber = validation.checkValid("1 * 3 + 2 - 4 3");
        Optional<Arithmetic> onlyNumber = validation.checkValid("1 3 6 2 4 7 9");

        //then
        assertThat(startWithDoubleNumber).isEmpty();
        assertThat(endWithDoubleNumber).isEmpty();
        assertThat(onlyNumber).isEmpty();
    }

    @DisplayName("공백 없는 입력 값 확인")
    @Test
    public void noSpace() {
        //given
        Optional<Arithmetic> noSpace = validation.checkValid("1+3-2*4");
        Optional<Arithmetic> noSpaceNegative = validation.checkValid("-3-5-6");

        //then
        assertThat(noSpace).isEmpty();
        assertThat(noSpaceNegative).isEmpty();
    }
}
