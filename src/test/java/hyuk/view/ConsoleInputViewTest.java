package hyuk.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleInputViewTest {

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }

    private InputView getInputView(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        InputView inputView = new ConsoleInputView(new Scanner(System.in));
        return inputView;
    }

    @DisplayName("메뉴 입력 테스트")
    @Test
    void selectMenu() {
        //given
        InputView inputView = getInputView("1");

        //when
        //then
        assertThat(inputView.selectMenu()).isEqualTo("1");
    }

    @DisplayName("메뉴 입력 예외 - 1, 2 이외의 한자리 입력")
    @Test
    void selectMenuException() {
        //given
        InputView inputView = getInputView("3");

        //when
        //then
        assertThatThrownBy(() -> inputView.selectMenu())
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("1 또는 2를 입력해주세요.");
    }

    @DisplayName("메뉴 입력 예외 - 긴 문자열 입력")
    @Test
    void selectMenuExceptionVer2() {
        //given
        InputView inputView = getInputView("1 2 23");

        //when
        //then
        assertThatThrownBy(() -> inputView.selectMenu())
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("1 또는 2를 입력해주세요.");
    }

    @DisplayName("계산식 입력 테스트")
    @Test
    void inputFormula() {
        //given
        InputView inputView = getInputView("1 + 2 * 3 + 4");

        //when
        String exp = inputView.inputFormula();

        //then
        assertThat(exp).isEqualTo("1 + 2 * 3 + 4");
    }

    @DisplayName("계산식 입력 테스트 - 오류1")
    @Test
    void FormulaException() {
        //given
        InputView inputView = getInputView("1 2 3 4");

        //when
        //then
        assertThatThrownBy(() -> inputView.inputFormula())
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("정규 표현식이 아닙니다.");
    }

    @DisplayName("계산식 입력 테스트 - 오류2")
    @Test
    void FormulaExceptionVer2() {
        //given
        InputView inputView = getInputView("1 2 3 4");

        //when
        //then
        assertThatThrownBy(() -> inputView.inputFormula())
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("정규 표현식이 아닙니다.");
    }

    @DisplayName("계산식 입력 테스트 - 오류3")
    @Test
    void FormulaExceptionVer3() {
        //given
        InputView inputView = getInputView("1 + 2 +");

        //when
        //then
        assertThatThrownBy(() -> inputView.inputFormula())
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("정규 표현식이 아닙니다.");
    }

}
