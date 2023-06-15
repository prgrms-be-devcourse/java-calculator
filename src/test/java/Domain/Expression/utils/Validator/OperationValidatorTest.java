package Domain.Expression.utils.Validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OperationValidatorTest {

    @Test
    void validate_Operation_true() {
        // given
        String s = "+";
        // when
        boolean b = OperationValidator.validate(s);
        // then
        assertThat(b).isTrue();
    }

    @Test
    void validate_Operation_false() {
        // given
        String s = ".";
        // when
        boolean b = OperationValidator.validate(s);
        // then
        assertThat(b).isFalse();
    }
}