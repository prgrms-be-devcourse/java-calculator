package hyuk.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @DisplayName("출력 테스트")
    @Test
    void printMenu() {
        //gievn
        //when
        consoleOutputView.printMenu();

        //then
        Assertions.assertThat(output.toString())
            .isEqualTo("1. 조회\n" +
                "2. 계산\n" +
                "\n" +
                "선택 : ");
    }

}
