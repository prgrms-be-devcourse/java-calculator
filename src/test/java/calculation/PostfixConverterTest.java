package calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class PostfixConverterTest {

    @Test
    @DisplayName("중위표기식을 후위표기식으로 변환")
    void convertTest() {
        String input = "(3 + (4 * 7)) - (6 / 3)";
        Converter converter = new PostfixConverter(input);
        String result = converter.convert();
        assertThat(result).isEqualTo("347*+63/-");
    }

}