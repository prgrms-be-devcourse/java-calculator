package programmers.java.calulator.console.runner;

import programmers.java.calulator.common.Calculator;
import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.writer.Writer;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConsoleRunnerTest {
    private Calculator calculator;
    private Reader reader;
    private Writer writer;
    private Map<String, Command> commands;
    private ConsoleRunner consoleRunner;

    @BeforeEach
    public void setUp() {
        calculator = Mockito.mock(Calculator.class);
        reader = Mockito.mock(Reader.class);
        writer = Mockito.mock(Writer.class);
        commands = new HashMap<>();
        consoleRunner = new ConsoleRunner(calculator, reader, writer, commands);
    }

    @Test
    @DisplayName("콘솔에서 실행이 잘 되는지 확인하는 테스트")
    public void 콘솔_실행_확인_테스트() {
        //given(setUp 메소드 포함)
        Command mockCommand = Mockito.mock(Command.class);
        commands.put("1", mockCommand);

        //when
        when(reader.readLine()).thenReturn("1", "3");
        consoleRunner.run();

        //then
        verify(writer, Mockito.times(1)).write(anyString());
        verify(mockCommand).execute();
    }

    @Test
    @DisplayName("1, 2가 아닌 잘못된 명령을 입력했을 때 예외 처리 테스트")
    public void 예외_처리_테스트() {
        //given(setUp 메소드 포함)
        Command mockCommand = Mockito.mock(Command.class);
        commands.put("1", mockCommand);

        //when
        when(reader.readLine()).thenReturn("3");

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            consoleRunner.run();
        });

        verify(writer, Mockito.times(3)).write(anyString());
    }
}