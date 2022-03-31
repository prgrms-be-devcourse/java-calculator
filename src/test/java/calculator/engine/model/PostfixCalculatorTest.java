package calculator.engine.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PostfixCalculatorTest {
    @Test
    @DisplayName("postfix calculator 테스트")
    void testPostfixCalculator() {
        assertThat(PostfixCalculator.getResult(new ArrayList<String>(Arrays.asList("3", "4", "1", "+", "*", "5", "-", "9", "2", "/", "+")))).isEqualTo(14.5);
        assertThat(PostfixCalculator.getResult(new ArrayList<String>(Arrays.asList("32", "8", "-", "4", "1.5", "3", "*", "+", "*", "5", "2", "*", "-", "9", "2", "/", "+")))).isEqualTo(198.5);
    }
}
