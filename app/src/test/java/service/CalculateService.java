package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
