package programmers.java.calulator.console.writer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleWriterTest {
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemOutput() {
        System.setOut(systemOut);
    }

    @Test
    @DisplayName("사용자에게 콘솔창에서 출력 화면이 잘 나오는지 출력 모듈 테스트")
    public void 출력_테스트() {
        // Given
        ConsoleWriter consoleWriter = new ConsoleWriter();
        String message = "test output";

        // When
        consoleWriter.write(message);

        // Then
        String expectedOutput = message + System.lineSeparator();
        assertEquals(expectedOutput, testOut.toString());
    }
}

