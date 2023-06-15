package com.bona.javacalculator.kernel;

import com.bona.javacalculator.core.calculator.Calculator;
import com.bona.javacalculator.core.converter.PostfixConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculateTest {

    Calculator calculator = new Calculator();
    PostfixConverter makePostfix = new PostfixConverter();

    @Test
    @DisplayName("결과값 반환 테스트")
    public void resultTest() {
        //given
        String input = "1+2*3";

        //when
        List<String> convert = makePostfix.convert(input);
        Double result = calculator.calculate(convert);

        //then
        Assertions.assertThat(result).isEqualTo(7);
    }

}