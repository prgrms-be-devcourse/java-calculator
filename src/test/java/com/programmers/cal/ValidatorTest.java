package com.programmers.cal;

import static org.assertj.core.api.Assertions.assertThat;

import com.programmers.cal.engine.model.InputData;
import com.programmers.cal.engine.validator.ExpressionValidator;
import com.programmers.cal.engine.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    Validator validator = new ExpressionValidator();
    InputData inputData = new InputData();

    @Test
    @DisplayName("식 검증 성공")
    public void successValidate() {
        //given
        InputData inputData1 = inputData.toInputData("12+34+45");
        InputData inputData2 = inputData.toInputData("1 2+ -34* 2");
        InputData inputData3 = inputData.toInputData("-12+-34+-45");

        //then
        assertThat(validator.isExpression(inputData1)).isTrue();
        assertThat(validator.isExpression(inputData2)).isTrue();
        assertThat(validator.isExpression(inputData3)).isTrue();
    }

    @Test
    @DisplayName("식 검증 실패")
    public void failValidate() {
        //given
        InputData inputData1 = inputData.toInputData("--12+34+45");
        InputData inputData2 = inputData.toInputData("12++34*2");
        InputData inputData3 = inputData.toInputData("12+34+45-");

        //then
        assertThat(validator.isExpression(inputData1)).isFalse();
        assertThat(validator.isExpression(inputData2)).isFalse();
        assertThat(validator.isExpression(inputData3)).isFalse();
    }
}
