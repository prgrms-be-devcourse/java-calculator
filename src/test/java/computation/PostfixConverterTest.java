package computation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixConverterTest {
    @Test
    @DisplayName("중위표기식을 후위표기식으로 변환")
    void convertTest() {
        String input = "(3 + (4 * 7)) - (6 / 3)";
        Converter converter = new PostfixConverter();
        List<String> result = converter.convert(input);
        assertThat(String.join("", result)).isEqualTo("347*+63/-");
    }

    @Test
    @DisplayName("연산자 우선순위 테스트")
    void priorityTest() {
        String input = "1 + 3 * 6";
        Converter converter = new PostfixConverter();
        List<String> result = converter.convert(input);
        assertThat(String.join("", result)).isEqualTo("136*+");

        input = "1 * (3 + 6)";
        result = converter.convert(input);
        assertThat(String.join("", result)).isEqualTo("136+*");
    }

}