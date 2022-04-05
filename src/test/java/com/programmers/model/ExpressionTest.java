package com.programmers.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {

    @Test
    public void 연산이_수행되지_않은상태에서_결과값을_가져올수없다() {
        //given
        String stringExpression = "1 + 2";
        //when
        Expression expression = new Expression(stringExpression);
        //then
        assertThatThrownBy(() -> expression.getCalcResult())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("연산에 대한 결과값은 연산 수행 후 조회가 가능합니다.");
    }

    @Test
    public void 빈공백이_들어오면_오류가_발생한다(){
        //given
        String stringExpression = "";
        //when
        //then
        assertThatThrownBy(() -> new Expression(stringExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자와 숫자가 제대로 입력되지 않았습니다.");
    }

    @Test
    public void 연산자와_피연산자의_순서가_맞지않을때_오류가_발생한다(){
        //given
        String stringExpression = "* 1 - 2";
        //when
        //then
        assertThatThrownBy(() -> new Expression(stringExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자와 숫자가 제대로 입력되지 않았습니다.");
    }

    @Test
    public void 연산자_혹은_숫자이외에_다른문자가_입력되면_오류가_발생한다(){
        //given
        String stringExpression = "a 1 - 2";
        //when
        //then
        assertThatThrownBy(() -> new Expression(stringExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자 혹은 숫자만 입력해주세요");
    }

}