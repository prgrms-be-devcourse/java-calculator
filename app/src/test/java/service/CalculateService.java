package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("더하기 빼기만 있는 경우 테스트")
    void calculateOnlyPlusAndMinus() throws Exception {
        // given
        String input = "1 + 2 - 3 + 4";

        // when
        Double result = calculateService.CalValue(input);

        // then
        assertEquals(4, result);
    }

    @Test
    @DisplayName("더하기 빼기 & 나누기 곱하기가 같이 있는 경우")
    void calculateWithAllOperator() throws Exception {
        // given
        String input = "1 + 2 - 3 * 4";

        // when
        Double result = calculateService.CalValue(input);

        // then
        assertEquals(-9, result);
    }

    @Test
    @DisplayName("분모가 0인 경우")
    void divisionByZero() {
        String input = "3 / 0";

        Exception exception = assertThrows(ArithmeticException.class, () -> calculateService.CalValue(input));
        assertEquals("0으로 나눌 수 없습니다.", exception.getMessage());
    }
}
