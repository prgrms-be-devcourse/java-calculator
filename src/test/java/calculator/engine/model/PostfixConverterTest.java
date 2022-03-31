package calculator.engine.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class PostfixConverterTest {
    @Test
    @DisplayName("postfix converter 테스트")
    void testPostfixConverter() {
        assertThat(PostfixConverter.convertToPostfix(new String[]{"3", "*", "(", "4", "+", "1", ")", "-", "5", "+", "9", "/", "2"})).isEqualTo(new ArrayList<String>(Arrays.asList("3", "4", "1", "+", "*", "5", "-", "9", "2", "/", "+")));
        assertThat(PostfixConverter.convertToPostfix(new String[]{"(", "32", "-", "8", ")", "*", "(", "4", "+", "1.5", "*", "3", ")", "-", "5", "*", "2", "+", "9", "/", "2"})).isEqualTo(new ArrayList<String>(Arrays.asList("32", "8", "-", "4", "1.5", "3", "*", "+", "*", "5", "2", "*", "-", "9", "2", "/", "+")));
    }
}
