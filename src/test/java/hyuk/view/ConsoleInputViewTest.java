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

    @DisplayName("메뉴 입력 예외")
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

    @DisplayName("계산식 입력 테스트")
    @Test
    void inputExp() {
        //given
        InputStream in = generateUserInput("1 + 2 * 3 + 4");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        //when
        String exp = inputView.inputExp(scanner);

        //then
        assertThat(exp).isEqualTo("1 + 2 * 3 + 4");
    }

}
