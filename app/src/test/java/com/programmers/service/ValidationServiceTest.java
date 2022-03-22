package com.programmers.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationServiceTest {
    ValidationService validationService = new ValidationService();

    @Test
    @DisplayName("case1 : 띄어쓰기가 안된경우")
    public void case1 () throws Exception{
        // given
        String input = "1+2+3*4";

        // when
        boolean result = validationService.validationInput(input);

        // then
        Assertions.assertEquals(result,false);

    }

    @Test
    @DisplayName("case2 : 숫자가 와야되는 위치에 숫자가 아닌 값이 입력된 경우")
    public void case2 () throws Exception{
        // given
        String input = "a + x + 3 * 4";

        // when
        boolean result = validationService.validationInput(input);

        // then
        Assertions.assertEquals(result,false);

    }

    @Test
    @DisplayName("case3 : 사칙연산 문자열 위치에 +, *, -, / 을 제외한 다른 값이 있는 경우")
    public void case3 () throws Exception{
        // given
        String input = "1 + 2 + 4 * 5 & 4";

        // when
        boolean result = validationService.validationInput(input);

        // then
        Assertions.assertEquals(result,false);

    }

    @Test
    @DisplayName("case4 : 마지막에 연산자로 끝나는 경우")
    public void case4 () throws Exception{
        // given
        String input = "1 + 2 + 4 * 5 * 3 -";

        // when
        boolean result = validationService.validationInput(input);

        // then
        Assertions.assertEquals(result,false);

    }
}