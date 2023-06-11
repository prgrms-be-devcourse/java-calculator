import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    static private Calculator calculator;
    static private CalculateService calculateService;
    static private ResultSaveService resultSaveService;

    @BeforeEach
    void setUp() {
        resultSaveService = new ResultSaveService("조회");
        calculateService = new CalculateService("계산");
        calculator = new Calculator(resultSaveService, calculateService);
    }

    @Test
    @DisplayName("올바른 계산식")
    void fullTextParsing() {
        String inputRefined = "2+3/2*6";

        assertThatCode(() -> calculateService.fullTextParsing(inputRefined))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("유효하지 않은 연산자가 앞에 오는 경우")
    void isValidFormula() {

        String badInput = "/2*4-3";
        assertThat(new CalculateService("test").isValidFormula(badInput)).isFalse();
    }

    @Test
    @DisplayName("빼기 계산 검증")
    public void calculate_test_minus() throws Exception {

        String goodInput = "1-10"; // -1
        LinkedList<String> strings = calculateService.fullTextParsing(goodInput);

        Assertions.assertThat(calculateService.plusOrMinus(strings)).isEqualTo("-9");
    }

    @Test
    @DisplayName("나누기 계산 검증")
    public void calculate_test_divide() throws Exception {
        String goodInput = "8/2"; // 4
        LinkedList<String> strings = calculateService.fullTextParsing(goodInput);

        Assertions.assertThat(calculateService.calculate(strings)).isEqualTo("4");
    }

    @Test
    @DisplayName("곱하기 계산 검증")
    public void calculate_test_multiply() throws Exception {
        String goodInput = "-2*1"; // -1
        LinkedList<String> strings = calculateService.fullTextParsing(goodInput);

        Assertions.assertThat(calculateService.calculate(strings)).isEqualTo("-2");
    }

    @Test
    @DisplayName("우선순위 계산 검증")
    public void calculate_test_complex() throws Exception {
        String goodInput = "3+2*4-1*3/3"; // 10
        LinkedList<String> strings =  calculateService.fullTextParsing(goodInput);

        Assertions.assertThat(calculateService.calculate(strings)).isEqualTo("10");
    }
}