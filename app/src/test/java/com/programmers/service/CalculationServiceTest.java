package com.programmers.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculationServiceTest {
    CalculationService calculationService = new CalculationService();

    @Test
    @DisplayName("숫자가 1개만 입력된경우 테스트")
    public void calculateOnlyOneValue () throws Exception{
        // given
        String input = "1";

        // when
        Double result = calculationService.calculate(input);

        // then
        Assertions.assertEquals(1d, result);

    }
    
    @Test
    @DisplayName("숫자가 여러개 입력된 복잡한 경우 테스트")
    public void calculateMoreThanOneValue () throws Exception{
        // given
        String input = "1 + 3 * 4 / 7 * 3 + 4 - 3 + 4 * 3";
        
        // when
        Double result = calculationService.calculate(input);

        // then
        Assertions.assertEquals(19.14d, result);

    }

    @Test
    @DisplayName("0으로 나눈경우")
    public void divideByZero () throws Exception{
        // given
        String input = "1 + 3 * 4 / 0 * 3 + 4 - 3 + 4 * 3";

        // when

        // then
        Exception e = Assertions.assertThrows(IllegalArgumentException.class,
                ()->calculationService.calculate(input));
    }

    @Test
    @DisplayName("계산값이 0 인경우")
    public void resultIsZero () throws Exception{
        // given
        String input = "1 - 1";

        // when
        Double result = calculationService.calculate(input);

        // then
        Assertions.assertEquals(0, result);
    }
}