package Domain.Execution;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OptionTest {

    @Test
    void from_정상값_INQUIRY_CALCULATE() {
        // given
        int choice1 = 1;
        int choice2 = 2;
        // when
        Option one = Option.from(choice1);
        Option two = Option.from(choice2);
        // then
        assertThat(one).isEqualTo(Option.INQUIRY);
        assertThat(one).isEqualTo(Option.CALCULATE);
    }

    @Test
    void from_이상한값_NONE() {
        // given
        int choice = 0;
        // when
        Option one = Option.from(choice);
        // then
        assertThat(one).isEqualTo(Option.NONE);
    }

    @Test
    void convert_정상값_INQUIRY() {
        // given
        int choice = 1;
        // when
        Option o = Option.from(choice);
        Execution convert = o.convert();
        // then
        assertThat(convert instanceof Inquiry).isTrue();
    }

    @Test
    void convert_정상값_Calculate() {
        // given
        int choice = 2;
        // when
        Option o = Option.from(choice);
        Execution convert = o.convert();
        // then
        assertThat(convert instanceof Calculate).isTrue();
    }

    @Test
    void convert_이상한값_None() {
        // given
        int choice = 0;
        // when
        Option o = Option.from(choice);
        Execution convert = o.convert();
        // then
        assertThat(convert instanceof None).isTrue();
    }
}