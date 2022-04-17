package javacalculator.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PostfixConvertorTest {
    @ParameterizedTest
    @DisplayName("후위 표기법 변환 기능 테스트-정상입력")
    @CsvSource({"1 + 2,1 2 +", "1 + 2 * 3,1 2 3 * +", "1 * 2 + 3,1 2 * 3 +"})
    void convert(String infix, String postfix) {
        String[] splitedInfix = infix.split(" ");
        String[] splitedPostfix = postfix.split(" ");
        assertThat(PostfixConvertor.convert(splitedInfix)).isEqualTo(splitedPostfix);
    }

    @Test
    @DisplayName("후위표기법_변환_기능_테스트-nullOrEmpty")
    void convertWithNullOrEmpty() {
        assertThatThrownBy(() -> PostfixConvertor.convert(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> PostfixConvertor.convert(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }
}
