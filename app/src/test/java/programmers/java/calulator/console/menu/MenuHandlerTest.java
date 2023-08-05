package programmers.java.calulator.console.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import programmers.java.calulator.common.calculator.Calculator;
import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.command.factory.CommandType;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.common.command.impl.ExecuteCalculationCommand;
import programmers.java.calulator.common.command.impl.PrintHistoryCommand;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuHandlerTest {
    private Writer writer;
    private Calculator calculator;
    private Reader reader;
    private Repository repository;
    private MenuHandler menuHandler;
    private static final String MENU_ITEM_SEPARATOR = ". ";

    @BeforeEach
    void setUp() {
        writer = Mockito.mock(Writer.class);
        calculator = Mockito.mock(Calculator.class);
        reader = Mockito.mock(Reader.class);
        repository = Mockito.mock(Repository.class);
        menuHandler = new MenuHandler(writer, calculator, reader, repository);
    }

    @Test
    @DisplayName("메뉴 출력 테스트")
    void 메뉴_출력_테스트() {
        //given
        int expectedMenuItems = CommandType.values().length;

        //when
        menuHandler.printMenu();

        //then
        verify(writer, times(expectedMenuItems)).write(contains(MENU_ITEM_SEPARATOR));
        verify(writer, times(1)).write("선택 : ");
    }

    @Test
    @DisplayName("메뉴 읽기 테스트")
    void 메뉴_읽기_테스트() {
        //given
        String expectedMenu = "1";
        when(reader.readLine()).thenReturn(expectedMenu);

        //when
        String menu = menuHandler.readMenu();

        //then
        assertEquals(expectedMenu, menu);
    }

    @Test
    @DisplayName("메뉴에 따른 커맨드 가져오기 테스트: 1번 명령")
    void 메뉴에_따른_명령_테스트1() {
        //given
        String menu = "1";

        //when
        Command command = menuHandler.getCommand(menu);

        //then
        assertTrue(command instanceof PrintHistoryCommand);
    }

    @Test
    @DisplayName("메뉴에 따른 커맨드 가져오기 테스트: 2번 명령")
    void 메뉴에_따른_명령_테스트2() {
        //given
        String menu = "2";

        //when
        Command command = menuHandler.getCommand(menu);

        //then
        assertTrue(command instanceof ExecuteCalculationCommand);
    }

    @Test
    @DisplayName("잘못된 메뉴 입력시 예외 처리 테스트")
    void getCommandTest_InvalidMenu() {
        //given
        String invalidMenu = "3";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            menuHandler.getCommand(invalidMenu);
        });
    }
}
