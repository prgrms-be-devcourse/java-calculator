package hyuk.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import hyuk.calculator.Result;
import hyuk.model.RecordsDTO;
import hyuk.model.ResultDTO;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ConsoleOutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    ConsoleOutputView consoleOutputView = new ConsoleOutputView();

    @Mock
    RecordsDTO recordsDTO;

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("메뉴 출력 테스트")
    @Test
    void printMenu() {
        //given
        //when
        consoleOutputView.printMenu();

        //then
        assertThat(output.toString())
            .isEqualTo("1. 조회\n" +
                "2. 계산\n" +
                "\n" +
                "선택 : ");
    }

    @DisplayName("계산 결과 출력 테스트")
    @Test
    void printResult() {
        //given
        //when
        consoleOutputView.printResult(new ResultDTO(new Result(10)));

        //then
        assertThat(output.toString())
            .isEqualTo("10\n\n");
    }

    @DisplayName("계산기 로그 조회")
    @Test
    void printRecords() {
        //given
        when(recordsDTO.getStringRecords()).thenReturn(Arrays.asList("1 + 2 * 3 + 4 = 11"));

        //when
        consoleOutputView.printRecords(recordsDTO);

        //then
        assertThat(output.toString())
            .isEqualTo("1 + 2 * 3 + 4 = 11\n\n");
    }

    @DisplayName("예외 출력")
    @Test
    void printException() {
        //given
        //when
        consoleOutputView.printException(new IllegalStateException("예외 메시지"));

        //then
        assertThat(output.toString())
            .isEqualTo("예외 메시지\n\n");
    }

}
