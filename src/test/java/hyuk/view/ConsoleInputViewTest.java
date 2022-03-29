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

    ConsoleInputView inputView = new ConsoleInputView();

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
    }

    @DisplayName("메뉴 입력 테스트")
    @Test
    void selectMenu() {
        //given
        InputStream in = generateUserInput("1");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        //then
        assertThat(inputView.selectMenu(scanner)).isEqualTo("1");
    }

    @DisplayName("메뉴 입력 예외 - 1, 2 이외의 한자리 입력")
    @Test
    void selectMenuException() {
        //given
        InputStream in = generateUserInput("3");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        //then
        assertThatThrownBy(() -> inputView.selectMenu(scanner))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("1 또는 2를 입력해주세요.");
    }

    @DisplayName("메뉴 입력 예외 - 긴 문자열 입력")
    @Test
    void selectMenuExceptionVer2() {
        //given
        InputStream in = generateUserInput("1 2 23");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        //then
        assertThatThrownBy(() -> inputView.selectMenu(scanner))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("1 또는 2를 입력해주세요.");
    }


    @DisplayName("계산식 입력 테스트")
    @Test
    void inputFormula() {
        //given
        InputStream in = generateUserInput("1 + 2 * 3 + 4");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        String exp = inputView.inputFormula(scanner);

        //then
        assertThat(exp).isEqualTo("1 + 2 * 3 + 4");
    }

    @DisplayName("계산식 입력 테스트 - 오류1")
    @Test
    void FormulaException() {
        //given
        InputStream in = generateUserInput("1 2 3 4");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        //then
        assertThatThrownBy(() -> inputView.inputFormula(scanner))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("정규 표현식이 아닙니다.");
    }

    @DisplayName("계산식 입력 테스트 - 오류2")
    @Test
    void FormulaExceptionVer2() {
        //given
        InputStream in = generateUserInput("1 2 3 4");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        //then
        assertThatThrownBy(() -> inputView.inputFormula(scanner))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("정규 표현식이 아닙니다.");
    }

    @DisplayName("계산식 입력 테스트 - 오류3")
    @Test
    void FormulaExceptionVer3() {
        //given
        InputStream in = generateUserInput("1 + 2 +");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        //then
        assertThatThrownBy(() -> inputView.inputFormula(scanner))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("정규 표현식이 아닙니다.");
    }

}
