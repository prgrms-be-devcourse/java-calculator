package programmers.java.calulator.console.runner;

import programmers.java.calulator.common.command.Command;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import programmers.java.calulator.console.menu.MenuHandler;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConsoleRunnerTest {
    private MenuHandler menuHandler;
    private ConsoleRunner consoleRunner;

    @BeforeEach
    public void setUp() {
        menuHandler = Mockito.mock(MenuHandler.class);
        consoleRunner = new ConsoleRunner(menuHandler);
    }

    @Test
    @DisplayName("콘솔에서 실행이 잘 되는지 확인하는 테스트")
    public void 콘솔_실행_확인_테스트() {
        //given
        Command mockCommand = Mockito.mock(Command.class);
        when(menuHandler.getCommand(anyString())).thenReturn(mockCommand);

        when(menuHandler.readMenu()).thenReturn("1").thenThrow(new RuntimeException("Test Exception"));

        //when
        assertThrows(RuntimeException.class, () -> consoleRunner.run());

        //then
        verify(menuHandler, Mockito.times(2)).printMenu();
        verify(mockCommand, Mockito.times(1)).execute();
    }

    @Test
    @DisplayName("1, 2가 아닌 잘못된 명령을 입력했을 때 예외 처리 테스트")
    public void 예외_처리_테스트() {
        //given
        when(menuHandler.readMenu()).thenReturn("3");
        when(menuHandler.getCommand(anyString())).thenThrow(new IllegalArgumentException("잘못된 입력입니다."));

        //then
        assertThrows(IllegalArgumentException.class, () -> consoleRunner.run());

        verify(menuHandler, Mockito.times(1)).printMenu();
    }
}
