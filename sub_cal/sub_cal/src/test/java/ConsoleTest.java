import model.HistoryEntity;
import option.Option;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {
    private static ByteArrayOutputStream outputMessage;
    private static HistoryEntity historyEntity;
    private static final Console console = new Console();

    private static final String NEW_LINE = "\n";

    @BeforeEach
    void setUpOutputStreams(){
        outputMessage = new ByteArrayOutputStream();
        historyEntity = new HistoryEntity();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
     void restoresStreams(){
        System.setOut(System.out);
    }
    @ParameterizedTest
    @CsvSource(value = {"1,HISTORY","2,CALCULATE"})
    void optionValue(String inputNumber,String optionResult) {
        Optional<Option> option = Option.getMenu(inputNumber);

        assertEquals(optionResult,option.get().getMenuName());
    }

    @Test
    void historyEmptyError() {
        console.historyEmptyError();
        assertEquals("조회된 데이터가 없습니다.",outputMessage.toString().strip());
    }

    @Test
    void showResultHistory() {
        historyEntity.addHistory("1 + 1","2");
        historyEntity.addHistory("3 * 2","6");

        console.showResultHistory(historyEntity.getHistory());

        assertEquals("1 + 1 = 2"+ NEW_LINE + "3 * 2 = 6",outputMessage.toString().strip());
    }

    @Test
    void printMenuList() {
        console.printMenuList();

        assertEquals("1.조회"+NEW_LINE+"2.계산",outputMessage.toString().strip());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    void printResult(String result) {
        console.printResult(result);

        assertEquals(result,outputMessage.toString().strip());
    }

    @Test
    void printInputExpressionMessage() {
        console.printInputExpressionMessage();

        assertEquals("계산식을 입력해주세요:",outputMessage.toString().strip());

    }
}
