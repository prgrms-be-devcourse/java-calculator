package com.programmers;

import com.programmers.core.converter.PostfixConverter;
import com.programmers.core.data.CalculationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostfixConverterTest {

    private PostfixConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PostfixConverter();
    }

    @Test
    @DisplayName("후위 표기식 변환 성공 테스트")
    void validFormula() {

        //given
        CalculationRequest request1 = new CalculationRequest("1 + 1 * 2");
        CalculationRequest request2 = new CalculationRequest("2 * 2 - 2 / 2");

        //when
        List<String> postfixFormula1 = converter.convert(request1);
        List<String> postfixFormula2 = converter.convert(request2);

        //then
        assertThat(postfixFormula1).containsExactly("1", "1", "2", "*", "+");
        assertThat(postfixFormula2).containsExactly("2", "2", "*", "2", "2", "/", "-");
    }

    @Test
    @DisplayName("후위 표기식 변환 실패 테스트_빈 수식")
    void emptyFormula() {
        CalculationRequest request = new CalculationRequest("");
        assertThrows(IllegalArgumentException.class, () -> converter.convert(request));
    }

    @Test
    @DisplayName("후위 표기식 변환 실패 테스트_null")
    void nullFormula() {
        CalculationRequest request = new CalculationRequest(null);
        assertThrows(IllegalArgumentException.class, () -> converter.convert(request));
    }

    @Test
    @DisplayName("후위 표기식 변환 실패 테스트_잘못된 수식")
    void invalidFormula() {
        CalculationRequest request = new CalculationRequest("1 + a");
        assertThrows(IllegalArgumentException.class, () -> converter.convert(request));
    }

    @Test
    @DisplayName("후위 표기식 변환 실패 테스트_완성되지 않은 식")
    void singleFormula() {
        CalculationRequest request = new CalculationRequest("+");
        assertThrows(IllegalArgumentException.class, () -> converter.convert(request));
    }
}

