package programmers.java.calulator.common.command.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import programmers.java.calulator.common.calculator.Calculator;
import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.common.command.impl.ExecuteCalculationCommand;
import programmers.java.calulator.common.command.impl.PrintHistoryCommand;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTypeTest {
    private final Writer writer = Mockito.mock(Writer.class);
    private final Calculator calculator = Mockito.mock(Calculator.class);
    private final Reader reader = Mockito.mock(Reader.class);
    private final Repository repository = Mockito.mock(Repository.class);

    @Test
    @DisplayName("PRINT_HISTORY Command 생성 및 값 확인 테스트")
    public void printHistoryCommandTest() {
        // given
        String expectedCommand = "1";
        String expectedDescription = "조회";

        // when
        Command command = CommandType.PRINT_HISTORY.createCommand(writer, calculator, reader, repository);

        // then
        assertEquals(expectedCommand, CommandType.PRINT_HISTORY.getCommand());
        assertEquals(expectedDescription, CommandType.PRINT_HISTORY.getDescription());
        assertTrue(command instanceof PrintHistoryCommand);
    }

    @Test
    @DisplayName("EXECUTE_CALCULATION Command 생성 및 값 확인 테스트")
    public void executeCalculationCommandTest() {
        // given
        String expectedCommand = "2";
        String expectedDescription = "계산";

        // when
        Command command = CommandType.EXECUTE_CALCULATION.createCommand(writer, calculator, reader, repository);

        // then
        assertEquals(expectedCommand, CommandType.EXECUTE_CALCULATION.getCommand());
        assertEquals(expectedDescription, CommandType.EXECUTE_CALCULATION.getDescription());
        assertTrue(command instanceof ExecuteCalculationCommand);
    }
}
