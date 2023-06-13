package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ViewMessageTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "     ", "\n", "qwer", "!@#$%"})
    @DisplayName("숫자가 아닌 입력이 들어온 경우")
    void getExceptionIfNoNumberInput(String noValidCommand) {
        // when, then
        assertThatThrownBy(() -> ViewMessage.getViewMessage(noValidCommand))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "4", "12343253", "-2", "-5", "-5435234"})
    @DisplayName("유효하지 않은 숫자 입력이 들어올 경우 ")
    void getExceptionIfNoValidNumberInput(String noValidCommand) {
        // when, then
        assertThatThrownBy(() -> ViewMessage.getViewMessage(noValidCommand))
                .isInstanceOf(NoSuchElementException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    @DisplayName("정상적인 명령이 입력된 경우")
    void getValidViewMessageIfValidNumberInput(String validCommand) {
        // when
        ViewMessage viewMessage = ViewMessage.getViewMessage(validCommand);
        int commandNumber = Integer.parseInt(validCommand);
        // then
        assertThat(viewMessage).isInstanceOf(ViewMessage.class);
        assertThat(viewMessage.getCommandNumber()).isEqualTo(commandNumber);
    }
}
