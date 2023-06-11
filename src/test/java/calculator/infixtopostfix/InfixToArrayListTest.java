package calculator.infixtopostfix;

import calculator.util.converter.InfixToPostfixConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InfixToArrayListTest {
    @Test
    @DisplayName("처음 입력 받은 중위 표현 수식을 배열로 변환 하기")
    void getInfixList() {
        Assertions.assertThat(new InfixToPostfixConverter().convert("1 + 5 * 2"))
                .isEqualTo(Arrays.asList("1", "5", "2", "*", "+"));
    }

    @Test
    @DisplayName("복잡한 중위 표현 수식을 후위 표현 수식으로 변환")
    void getPrefix(){
        Assertions.assertThat(new InfixToPostfixConverter().convert("3 + 6 * 2 / 3"))
                .isEqualTo(Arrays.asList("3", "6", "2", "*", "3", "/", "+"));
    }
}
