package test;

import org.junit.Test;
import src.exception.ErrorMessage;
import src.io.ConsoleWriter;
import src.log.Log;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    private final ConsoleWriter cw = new ConsoleWriter();
    private final OutputStream out = setMockOutputStream();



    @Test
    public void printPrompt(){
        //given
        String expectedStr = "1. 조회\n" +
                             "2. 계산\n\n" +
                             "선택 : ";

        //when
        cw.printPrompt();

        //then
        String result = out.toString();
        assertThat(result).isEqualTo(expectedStr);

    }
    @Test
    public void printError(){
        //given
        String expectedStr = ErrorMessage.INVALID_EXPRESSION.getMessage()+"\n\n";

        //when
        cw.printError(ErrorMessage.INVALID_EXPRESSION.getMessage());

        //then
        String result = out.toString();
        assertThat(result).isEqualTo(expectedStr);
    }

    @Test
    public void printLog(){
        //given
        List<Log> logs = Arrays.asList(Log.createLog("1 + 2", "3"),
                                       Log.createLog("1 * 5", "5"));


        String expectedStr = "1 + 2 = 3\n" +
                             "1 * 5 = 5\n\n";

        //when
        cw.printLog(logs);

        //then
        String result = out.toString();
        assertThat(result).isEqualTo(expectedStr);
    }

    @Test
    public void printAnswer(){
        //given
        String answer = "10";
        String expectedStr = "10\n\n";

        //when
        cw.printAnswer(answer);

        //then
        String result = out.toString();
        assertThat(result).isEqualTo(expectedStr);
    }


    private OutputStream setMockOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }
}
