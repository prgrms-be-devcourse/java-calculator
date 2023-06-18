package programmers.java.calulator.common.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import programmers.java.calulator.common.calculator.Calculator;
import programmers.java.calulator.common.command.factory.CommandType;
import programmers.java.calulator.common.command.impl.ExecuteCalculationCommand;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.repository.History;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;

public class ExecuteCalculationCommandTest {

    @Test
    @DisplayName("사용자의 계산기 실행 명령이 작동하는지 확인하는 테스트")
    public void 계산기_실행_테스트() {
        // given
        Calculator mockCalculator = Mockito.mock(Calculator.class);
        Reader mockReader = Mockito.mock(Reader.class);
        Writer mockWriter = Mockito.mock(Writer.class);
        Repository mockRepository = Mockito.mock(Repository.class);

        when(mockReader.readLine()).thenReturn("2 + 2");
        when(mockCalculator.calculate("2 + 2")).thenReturn(4);

        ExecuteCalculationCommand command = new ExecuteCalculationCommand(mockCalculator, mockReader, mockWriter, mockRepository);

        // when
        command.execute();

        // then
        verify(mockCalculator, times(1)).calculate("2 + 2");
        verify(mockWriter, times(1)).write("4");
        verify(mockRepository, times(1)).save(any(History.class));
    }

    @Test
    @DisplayName("ExecuteCalculationCommand의 CommandType 반환 테스트")
    public void CommandType_반환_테스트() {
        // given
        Calculator mockCalculator = Mockito.mock(Calculator.class);
        Reader mockReader = Mockito.mock(Reader.class);
        Writer mockWriter = Mockito.mock(Writer.class);
        Repository mockRepository = Mockito.mock(Repository.class);

        ExecuteCalculationCommand command = new ExecuteCalculationCommand(mockCalculator, mockReader, mockWriter, mockRepository);

        // when
        CommandType commandType = command.getCommandType();

        // then
        assertEquals(CommandType.EXECUTE_CALCULATION, commandType);
    }
}
