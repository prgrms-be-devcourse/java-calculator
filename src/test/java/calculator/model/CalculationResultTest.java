package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculationResultTest {
    @ParameterizedTest
    @DisplayName("CalculationResult의 객체 생성 후 expression과 result를 올바르게 출력하는지 검증하는 테스트")
    @MethodSource("testData")
    void expression_and_answer(String expression, Integer answer, String result){
        CalculationResult calculationResult = new CalculationResult(expression, answer);
        Assertions.assertEquals(calculationResult.toString(), result);
    }

    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of("3 + 5", 8, "3 + 5 = 8"),
                Arguments.of("3 + 8 * -1", -5, "3 + 8 * -1 = -5"),
                Arguments.of("3 + 1 - 1", 3, "3 + 1 - 1 = 3")
        );
    }

    @ParameterizedTest
    @DisplayName("오버라이딩한 Calculation Result의 ToString 테스트")
    @CsvSource({
            "3 + 5, 8, 3 + 5 = 8",
            "-2 * 1, -2, -2 * 1 = -2"
    })
    void testToString(String expression, Integer answer, String expectedResult) {
        CalculationResult result = new CalculationResult(expression, answer);

        Assertions.assertEquals(expectedResult, result.toString());
    }
}