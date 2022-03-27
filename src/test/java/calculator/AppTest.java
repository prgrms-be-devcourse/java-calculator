package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @DisplayName("Test Ok?")
    @Test
    void assertjTest() {
        String s = "aaa";
        String s2 = "aaa";

        assertThat(s).isEqualTo(s2);
    }
}