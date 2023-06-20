package com.programmers;

import com.programmers.core.calculator.PostfixCalculator;
import com.programmers.core.converter.Converter;
import com.programmers.core.converter.PostfixConverter;
import com.programmers.core.data.CalculationRequest;
import com.programmers.core.data.CalculationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private PostfixCalculator calculator;

    @BeforeEach
    void setUp() {
        Converter converter = new PostfixConverter();
        calculator = new PostfixCalculator(converter);
    }

    @Test
    @DisplayName("더하기 테스트")
    void addTest() throws Exception {
        //given
        CalculationRequest request = new CalculationRequest("1 + 2");
        CalculationResult expected = new CalculationResult(request.getFormula(), 3);

        //when
        CalculationResult result = calculator.calculate(request);

        //then
        assertThat(result.getResult()).isEqualTo(expected.getResult());
    }

    @Test
    @DisplayName("빼기 테스트")
    void subtractionTest() throws Exception {
        //given
        CalculationRequest request = new CalculationRequest("1 - 2");
        CalculationResult expected = new CalculationResult(request.getFormula(), -1);

        //when
        CalculationResult result = calculator.calculate(request);

        //then
        assertThat(result.getResult()).isEqualTo(expected.getResult());
    }


    @Test
    @DisplayName("곱하기 테스트")
    void multiplyTest() throws Exception {
        //given
        CalculationRequest request = new CalculationRequest("2 * 2");
        CalculationResult expected = new CalculationResult(request.getFormula(), 4);

        //when
        CalculationResult result = calculator.calculate(request);

        //then
        assertThat(result.getResult()).isEqualTo(expected.getResult());
    }


    @Test
    @DisplayName("나누기 테스트")
    void divideTest() throws Exception {
        //given
        CalculationRequest request = new CalculationRequest("2 / 2");
        CalculationResult expected = new CalculationResult(request.getFormula(), 1);

        //when
        CalculationResult result = calculator.calculate(request);

        //then
        assertThat(result.getResult()).isEqualTo(expected.getResult());
    }

    @Test
    @DisplayName("계산 실패_잘못된 수식")
    public void testInvalidFormula() {
        CalculationRequest request = new CalculationRequest("3 4 + +");

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(request));
    }

    @Test
    @DisplayName("계산 실패_빈 수식")
    void testEmptyFormula() throws Exception {
        CalculationRequest request = new CalculationRequest("");

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(request));
    }

    @Test
    @DisplayName("계산 실패_null값")
    void testNullFormula() throws Exception {
        CalculationRequest request = new CalculationRequest(null);

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(request));
    }

    @Test
    @DisplayName("계산 실패_피연산자가 아닌 문자열 입력")
    void testInvalidOperand() throws Exception {
        CalculationRequest request = new CalculationRequest("3 + a");

        assertThrows(NumberFormatException.class, () -> calculator.calculate(request));
    }

    @Test
    @DisplayName("계산 실패_0으로 나누는 경우")
    void testDivideByZero() throws Exception {
        CalculationRequest request = new CalculationRequest("3 / 0");

        assertThrows(ArithmeticException.class, () -> calculator.calculate(request));
    }
}
