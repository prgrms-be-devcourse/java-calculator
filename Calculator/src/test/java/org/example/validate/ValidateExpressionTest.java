package org.example.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateExpressionTest {
    ValidateExpression validateExpression = new ValidateExpression();
    @Test
    void 수식_검증() {
        //given
        String input = "1 + 2 + 3";
        //when
        boolean result = validateExpression.isValidExpression(input);
        //then
        Assertions.assertEquals(result,true);
    }


}