package com.programmers;

import com.programmers.core.Converter;
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
        Converter postfixConverter = new PostfixConverter();
        //given
        String formula1 = "1 + 2 * 3";
        String formula2 = "3 + 5 / 1 + 2 / 2";
        //when
        List<String> postfixFormula1 = postfixConverter.convert(formula1);
        List<String> postfixFormula2 = postfixConverter.convert(formula2);
        //then
        assertThat(postfixFormula1).containsExactly("1", "2", "3", "*", "+");
        assertThat(postfixFormula2).containsExactly("3", "5", "1", "/", "+", "2", "2", "/", "+");
    }

    @Test
    @DisplayName("후위 표기식 변환 실패 테스트")
    void postfixFormulaConversionFailed() throws Exception {
        Converter postfixConverter = new PostfixConverter();

        String formula = "1 + 2 * 3 + a ";

        Assertions.assertThrows(IllegalArgumentException.class, () -> postfixConverter.convert(formula));
    }
}

