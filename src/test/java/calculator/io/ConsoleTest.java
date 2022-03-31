package calculator.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;


public class ConsoleTest {

    Input input;
    Output output;
    InputStream in;
    Map<String, Integer> mock;

    @BeforeEach
    void beforeEach() {
        mock = new LinkedHashMap<>();
        mock.put("1+2", 3);
        mock.put("1+2*3", 7);
    }
    private InputStream consoleInputHelp(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
    }
    private OutputStream consoleOutputHelp() {
        return new ByteArrayOutputStream();
    }

    @DisplayName("사용자가 값을 입력했을 때 잘 입력되는지")
    @ParameterizedTest
    @ValueSource(strings = "3+5-4*6")
    void inputTest(String want) {
//        유저가 값을 넣음
        in = consoleInputHelp(want);
        System.setIn(in);

//        값을 읽어올 방법 선택 (미리 열지 않는 이유는 setIn 이후 InputStream이 닫히면서 값을 읽으려고 시도시
//        NoSuchElementException 발생)
        input = new Console();

//        값을 읽어옴
        String got = input.read();

//        값이 잘 읽히는지 확인
        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("답이 콘솔에 잘 출력되는지")
    @Test
    void outputTest() {
        final String want = "4\n";
        OutputStream out = consoleOutputHelp();
        System.setOut(new PrintStream(out));
        output = new Console();
        output.answerPrint(4);
        Assertions.assertThat(out.toString()).isEqualTo(want);
    }

    @DisplayName("히스토리의 형태가 원하는 형태로 출력되는지")
    @Test
    void historyOutputTest() {
        final String want = "1+2=3\n";
        OutputStream out = consoleOutputHelp();
        System.setOut(new PrintStream(out));

        output = new Console();
        output.historyPrintFormat("1+2", 3);

        Assertions.assertThat(out.toString()).isEqualTo(want);
    }
}
