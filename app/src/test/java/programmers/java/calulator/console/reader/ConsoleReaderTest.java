package programmers.java.calulator.console.reader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleReaderTest {

    @Test
    @DisplayName("사용자가 콘솔창에 입력 했을 때 입력을 잘 받는지 확인하는 테스트")
    public void testReadLine() {
        // Given
        String input = "test input\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ConsoleReader consoleReader = new ConsoleReader();

        // When
        String line = consoleReader.readLine();

        // Then
        assertEquals("test input", line);
    }
}
