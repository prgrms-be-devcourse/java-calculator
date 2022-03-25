package hyuk.view;

import hyuk.entity.LogDTO;
import hyuk.entity.Result;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleOutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    ConsoleOutputView consoleOutputView = new ConsoleOutputView();

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
        Assertions.assertThat(output.toString())
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
        consoleOutputView.printResult(new Result(10));

        //then
        Assertions.assertThat(output.toString())
            .isEqualTo("10\n");
    }

    @DisplayName("계산기 로그 조회")
    @Test
    void printLogs() {
        //given
        LogDTO logDTO = new LogDTO(Arrays.asList("1 + 2 * 3 + 4 = 11", "1 + 2 = 3"));

        //when
        consoleOutputView.printLogs(logDTO);

        //then
        Assertions.assertThat(output.toString())
            .isEqualTo("1 + 2 * 3 + 4 = 11\n" +
                "1 + 2 = 3\n\n");
    }

}
