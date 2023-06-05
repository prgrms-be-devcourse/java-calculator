package java.calculator.console.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.calculator.common.writer.Writer;
import java.calculator.console.repository.Repository;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class PrintHistoryCommandTest {

    @Test
    @DisplayName("사용자의 계산 기록 출력 명령이 작동하는지 확인하는 테스트")
    public void whenExecuteIsCalled_thenPrintAllHistory() {
        // given
        Repository mockRepository = Mockito.mock(Repository.class);
        Writer mockWriter = Mockito.mock(Writer.class);

        Map<String, Integer> mockHistory = new HashMap<>();
        mockHistory.put("2 + 2", 4);
        mockHistory.put("3 * 3", 9);

        when(mockRepository.getRepository()).thenReturn(mockHistory);

        PrintHistoryCommand command = new PrintHistoryCommand(mockWriter, mockRepository);

        // when
        command.execute();

        // then
        verify(mockWriter, times(1)).write("2 + 2 = 4");
        verify(mockWriter, times(1)).write("3 * 3 = 9");
    }
}