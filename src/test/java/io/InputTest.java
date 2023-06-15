package io;

import com.programmers.error.CalculatorException;
import com.programmers.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.programmers.error.ErrorMessage.NOT_VALID_ARITHMETIC_EXPRESSION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


public class InputTest {

    @DisplayName("메뉴와 식의 공백이 정상적으로 제거되면 성공")
    @ParameterizedTest
    @CsvSource(value = {"3   ,3", "34 + 4 5  *  2,34+45*2"}, delimiter = ',')
    void 공백_제거_테스트(String input, String output) {
        assertEquals(Input.removeWhiteSpace(input), output);
    }

    @DisplayName("메뉴 정상 입력 시 성공")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "2:2", "1        :1"}, delimiter = ':')
    void input_메뉴_테스트(String beforeProcessMenu, String afterProcessMenu) {
        String testResult = String.valueOf(Input.processMenu(beforeProcessMenu));
        assertEquals(testResult, afterProcessMenu);
    }

    @DisplayName("[실패] 식이 유효하지 않을 때 성공")
    @ParameterizedTest
    @ValueSource(strings = {"3 + 4 /", "3+4**"})
    void input_식_테스트(String beforeProcessExpression) {
        assertThatThrownBy(() -> Input.processExpression(beforeProcessExpression))
                .isInstanceOf(CalculatorException.class)
                .hasMessageContaining(NOT_VALID_ARITHMETIC_EXPRESSION.getMessage());
    }


}
