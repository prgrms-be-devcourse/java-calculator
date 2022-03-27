package test;

import org.junit.Before;
import org.junit.Test;
import src.exception.ErrorMessage;
import src.io.ConsoleReader;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    private ConsoleReader cr;

    @Before
    public void setup(){
        cr = new ConsoleReader(System.in);
    }
    @Test
    public void getChoice(){
        //given
        int input = 1;
        setMockInputStream(String.valueOf(input)); //input -> bytestream <- scanner

        //when
        int result = cr.getChoice();

        //then
        assertThat(result).isEqualTo(input);
    }

    @Test
    public void getChoiceWithInvalidInput(){
        //given
        setMockInputStream("sdfasdf");

        //when
        //then
        assertThatThrownBy(() -> cr.getChoice())
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_CHOICE.getMessage());

    }

    @Test
    public void getNextLine(){
        //given
        String input = "test";
        setMockInputStream(input);

        //when
        String result = cr.getNextLine();

        //then
        assertThat(result).isEqualTo(input);

    }


    /**
     *  1. 입력 문자열을 바이트 코드로 바꾼 다음
     *  2. 바이트 코드를 ByteArrayInputStream의 인자로 넘겨 InputStream을 생성
     *  3. InputStream을 System.in으로 세팅
     *  4. Scanner에서는 InputStream에서 데이터를 읽는다.
     */
    private void setMockInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        cr = new ConsoleReader(System.in);

    }
}
