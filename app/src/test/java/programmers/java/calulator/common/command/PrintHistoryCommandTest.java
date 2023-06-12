package programmers.java.calulator.common.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import programmers.java.calulator.common.command.factory.CommandType;
import programmers.java.calulator.common.command.impl.PrintHistoryCommand;
import programmers.java.calulator.common.repository.History;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.console.repository.MapHistory;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PrintHistoryCommandTest {

    @Test
    @DisplayName("사용자의 계산 기록 출력 명령이 작동하는지 확인하는 테스트")
    public void 계산기_기록_출력_테스트() {
        // given
        Repository mockRepository = Mockito.mock(Repository.class);
        Writer mockWriter = Mockito.mock(Writer.class);

        History history1 = new MapHistory("2 + 2", 4);
        History history2 = new MapHistory("3 * 3", 9);
        List<History> mockHistoryList = List.of(history1, history2);

        when(mockRepository.findAll()).thenReturn(mockHistoryList);

        PrintHistoryCommand command = new PrintHistoryCommand(mockWriter, mockRepository);

        // when
        command.execute();

        // then
        verify(mockWriter, times(1)).write(history1.toString());
        verify(mockWriter, times(1)).write(history2.toString());
    }

    @Test
    @DisplayName("PrintHistoryCommand의 CommandType 반환 테스트")
    public void CommandType_반환_테스트() {
        // given
        Writer mockWriter = Mockito.mock(Writer.class);
        Repository mockRepository = Mockito.mock(Repository.class);

        PrintHistoryCommand command = new PrintHistoryCommand(mockWriter, mockRepository);

        // when
        CommandType commandType = command.getCommandType();

        // then
        assertEquals(CommandType.EXECUTE_CALCULATION, commandType);
    }
}
