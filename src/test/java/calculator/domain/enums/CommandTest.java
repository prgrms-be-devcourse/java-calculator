package calculator.domain;

import calculator.domain.enums.Command;
import calculator.exception.ApplicationException;
import calculator.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Enum Command 테스트")
public class CommandTest {
    @ParameterizedTest
    @ValueSource(strings = {"4", " ", "a", "?", "ㄱ"})
    void 입력값이_123이아닌옵션이들어온다면_예외발생(String input) {
        // when && than
        assertThatThrownBy(() -> Command.from(input))
                .isInstanceOf(ApplicationException.class)
                .hasMessageContaining(ErrorMessage.NOT_FOUND_OPTION.getMessage());
    }

    @Test
    void 입력값1이_조회라면_리턴true() {
        // given
        String input = "1";

        // when
        Command command = Command.from(input);

        // then
        assertThat(command.isHistory()).isTrue();
    }

    @Test
    void 입력값이_계산라면_리턴true() {
        // given
        String input = "2";

        // when
        Command command = Command.from(input);

        // then
        assertThat(command.isCalculation()).isTrue();
    }

    @Test
    void 입력값3이_종료라면_리턴true() {
        // given
        String input = "3";

        // when
        Command command = Command.from(input);

        // then
        assertThat(command.isExit()).isTrue();
    }
}
