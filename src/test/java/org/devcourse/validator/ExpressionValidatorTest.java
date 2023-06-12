package org.devcourse.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionValidatorTest {

    private final Validator<String> validator = new ExpressionValidator<>();

    @ParameterizedTest
    @DisplayName("올바른 수식에 대한 검증")
    @ValueSource(
            strings = {"1+10*5",
                    "(1+10)*5",
                    "-1+10*5",
                    "(2+10)/2*(-1)*5",
                    "0/15",
                    "((10-5)/5*10*(-5)+500)"}

    )
    void correctInputExpression(String expression) {

        System.out.println("expression = " + expression);
        Assertions.assertThat(validator.validate(expression)).isEqualTo(true);

    }



    @ParameterizedTest
    @DisplayName("올바르지 못한 수식에 대한 검증")
    @ValueSource(
            strings = {"1+10)10*5",
                    "(1+10)*5)",
                    "((-1+10)*5",
                    "(2+10)/*2*(-1)*5",
                    "((10-5)+/5*10*(-5)+500)",
                    "#1+3+4"}

    )
    void wrongInputExpression(String expression) {

        Assertions.assertThat(validator.validate(expression)).isEqualTo(false);

    }

}