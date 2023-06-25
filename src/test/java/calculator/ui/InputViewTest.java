package calculator.ui;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.IllegalException;
import util.Menu;
import util.ValidationInput;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {
            ""
            ," "
    })
    void 입력이_들어오지않는다면_에러반환(String userInput) {
        assertThatThrownBy(()-> ValidationInput.isEmpty(userInput))
                .isInstanceOf(IllegalException.class);
    }


    @Nested
    class checkMenu_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {
                ","
                , "123"
                , "가"
                , "+나다"
                , "마바사"
                , "abc"
        })
        void 메뉴번호가_1_2가_아니면_에러반환(String userInput) {
            assertThatThrownBy(()-> Menu.getMenu(userInput))
                    .isInstanceOf(IllegalException.class);
        }
    }

    @Nested
    class equation_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {
                "+++++"
                , "+"
                , "1+" , "1 + 1 +", "1++1"
                , "1 1"
                ,"+ +"
                ,"( 1 + 2 ("
                ,"1 + 2 * ) ( 3 + 4 ) - 5"
                ,"( 1 + 2 ) ( 3 + 4 )"
                ,"( ( ) ) 1 + 1 + 2"
                ,"1 + 1 ( ) + 2"
                ,"1 + 1 ( + ) 2"
        })
        void 계산식의_형식이_아니면_에러반환(String userInput) {
            assertThatThrownBy(()-> ValidationInput.checkEquation(userInput))
                    .isInstanceOf(IllegalException.class);
        }
    }
}
