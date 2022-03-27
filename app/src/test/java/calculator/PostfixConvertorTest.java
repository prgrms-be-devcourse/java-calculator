package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PostfixConvertorTest {
    @Test
    @DisplayName("후위표기법_변환_기능_테스트")
    void convert() {
        assertThatThrownBy(() -> PostfixConvertor.convert(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> PostfixConvertor.convert(new String[]{})).isInstanceOf(IllegalArgumentException.class);
        assertThat(PostfixConvertor.convert(new String[]{"1", "+", "2"})).isEqualTo(new String[]{"1", "2", "+"});
        assertThat(PostfixConvertor.convert(new String[]{"1", "+", "2", "*", "3"})).isEqualTo(new String[]{"1", "2", "3", "*", "+"});
        assertThat(PostfixConvertor.convert(new String[]{"1", "*", "2", "+", "3"})).isEqualTo(new String[]{"1", "2", "*", "3", "+"});
    }
}
