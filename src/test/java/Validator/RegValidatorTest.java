package Validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RegValidatorTest {

    private final Validator validator = new RegularExpressionValidator();

    @ParameterizedTest
    @ValueSource(strings = {"1+2", "3 * 4", "2- 1", "3  /4", "1*2+3/4*5-7+21*100/1245"})
    @DisplayName("다음의 수식은 올바른 수식이다.")
    void _1(String s) {
        boolean parse = validator.validate(s);
        assertThat(parse).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1+2", "2+3*", "1+2+3+4+5+6+8-", "123+2a"})
    @DisplayName("다음 수식은 올바르지 않은 수식이다")
    void _2(String s) {
        boolean parse = validator.validate(s);
        assertThat(parse).isFalse();
    }

}