package Domain.Expression.utils.Validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {
    @Test
    void validate_number_true() {
        // given
        String s = "12123";
        // when
        boolean b = NumberValidator.validate(s);
        // then
        assertThat(b).isTrue();
    }

    @Test
    void validate_not_number_false() {
        // given
        String s = "dsadsd";
        // when
        boolean b = NumberValidator.validate(s);
        // then
        assertThat(b).isFalse();
    }
}