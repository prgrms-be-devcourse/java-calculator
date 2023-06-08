import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

class InputReaderTest {
    InputReader inputReader = new InputReader();

//    @Test
//    @DisplayName("조회 명령어 테스트")
//    void commandInputTest() {
//        // given
//        String HISTORY_COMMAND = "1";
//        InputStream in = new ByteArrayInputStream(HISTORY_COMMAND.getBytes());
//        System.setIn(in);
//        int command = Integer.parseInt(HISTORY_COMMAND);
//
//        // when
//        CommandType expected = CommandType.getCommandType(command);
//        CommandType actual = inputReader.readUserCommand();
//
//        // then
//        Assertions.assertThat(actual).isEqualTo(expected);
//    }

//    @Test
//    @DisplayName("계산 명령어 테스트")
//    void commandIㅇnputTest() {
//        InputStream in = new ByteArrayInputStream(inputCommand.getBytes());
//        System.setIn(in);
//        int command = Integer.parseInt(inputCommand);
//
//        // when
//        CommandType expected = CommandType.getCommandType(command);
//        CommandType actual = inputReader.readUserCommand();
//
//        // then
//        Assertions.assertThat(actual).isEqualTo(expected);
//    }

}
