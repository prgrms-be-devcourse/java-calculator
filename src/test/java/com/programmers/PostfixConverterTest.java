package com.programmers;

import com.programmers.core.PostfixConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PostfixConverterTest {

    @Test
    @DisplayName("후위 표기식 변환 성공 테스트")
    void postfixFormulaConversionSuccessful() throws Exception {
        //given
        String formula1 = "1 + 2 * 3";
        String formula2 = "3 + 5 / 1 + 2 / 2";
        //when
        List<String> postfixFormula1 = PostfixConverter.convert(formula1);
        List<String> postfixFormula2 = PostfixConverter.convert(formula2);
        //then
        assertThat(postfixFormula1).containsExactly("1", "2", "3", "*", "+");
        assertThat(postfixFormula2).containsExactly("3", "5", "1", "/", "+", "2", "2", "/", "+");
    }

    @Test
    @DisplayName("후위 표기식 변환 실패 테스트")
    void postfixFormulaConversionFailed() throws Exception {
        String formula = "1 + 2 * 3 + a ";

        Assertions.assertThrows(IllegalArgumentException.class, () -> PostfixConverter.convert(formula));
    }
}

