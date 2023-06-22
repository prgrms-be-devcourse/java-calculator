package view;

import exception.NoSuchCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "     ", "\n", "qwer", "!@#$%"})
    @DisplayName("숫자가 아닌 입력이 들어온 경우")
    void getExceptionIfNoNumberInput(String noValidCommand) {
        // given

        // when, then
        assertThatThrownBy(() -> Command.resolveCommand(noValidCommand))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "4", "12343253", "-2", "-5", "-5435234"})
    @DisplayName("유효하지 않은 숫자 입력이 들어올 경우 ")
    void getExceptionIfNoValidNumberInput(String noValidCommand) {
        // when, then
        assertThatThrownBy(() -> Command.resolveCommand(noValidCommand))
                .isInstanceOf(NoSuchCommandException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    @DisplayName("정상적인 명령이 입력된 경우")
    void getValidViewMessageIfValidNumberInput(String validCommand) {
        // given

        // when
        Command viewMessage = Command.resolveCommand(validCommand);
        int commandNumber = Integer.parseInt(validCommand);
        // then
        assertThat(viewMessage).isInstanceOf(Command.class);
        assertThat(viewMessage.getCommandNumber()).isEqualTo(commandNumber);
    }
}
