import option.Option;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {
    Console console = new Console();


    @Test
    void selectOptionTest(){
        Assertions.assertThrows(NoSuchElementException.class,()->{
            Optional<Option> userOption = Option.getMenu("3");
            userOption.get();
        });

    }

    @Test
    void inputStringTest() {

    }

//    @Test
//    void historyEmptyError() {
//        Assertions.assertEquals("조회된 데이터가 없습니다.",console.historyEmptyError());
//    }

    @Test
    void showResultHistory() {
    }

    @Test
    void printMenuList() {
    }

    @Test
    void printInvalidMenuErrorMessage() {
    }

    @Test
    void printResult() {
    }

    @Test
    void printInputExpressionMessage() {
    }

    @Test
    void printEmptyInputExpressionMessage() {
    }
}
