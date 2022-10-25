package com.programmers.cal;

import static org.assertj.core.api.Assertions.assertThat;

import com.programmers.cal.engine.validator.ExpressionValidator;
import com.programmers.cal.engine.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    Validator validator = new ExpressionValidator();

    @Test
    @DisplayName("식 검증 성공")
    public void successValidate() {
        //given
        String inputString1 = "12+34+45";
        String inputString2 = "1 2+ -34* 2";
        String inputString3 = "-12+-34+-45";

        //then
        assertThat(validator.isExpression((inputString1))).isTrue();
        assertThat(validator.isExpression((inputString2))).isTrue();
        assertThat(validator.isExpression((inputString3))).isTrue();
    }

    @Test
    @DisplayName("식 검증 실패")
    public void failValidate() {
        //given
        String inputString1 = "--12+34+45";
        String inputString2 = "12++34*2";
        String inputString3 = "12+34+45-";

        //then
        assertThat(validator.isExpression((inputString1))).isFalse();
        assertThat(validator.isExpression((inputString2))).isFalse();
        assertThat(validator.isExpression((inputString3))).isFalse();
    }
}
