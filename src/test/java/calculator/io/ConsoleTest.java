package calculator.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class ConsoleTest {

    Input input;
    InputStream in;


    private InputStream consoleInputHelp(String userInput) {
        return new ByteArrayInputStream(userInput.getBytes());
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
}
