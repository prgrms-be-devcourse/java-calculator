package calculator.ui;

import exception.NotMenuFormatExcpetion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.Menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {
            ""
            ," "
    })
    void 입력이_들어오지않는다면_에러반환(String userInput) {
        assertThatThrownBy(()->CheckInputException.isEmpty(userInput))
                .isInstanceOf(NotMenuFormatExcpetion.class);
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
            Menu menu = Menu.getMenu(userInput);

            assertThatThrownBy(()-> CheckInputException.checkMenuNumber(menu))
                    .isInstanceOf(NotMenuFormatExcpetion.class);
        }
    }

    @Nested
    class equation_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {
                "+"
        })
        void 계산식의_입력에_숫자와_사칙연산_괄호가_아니면_에러반환(String userInput) {

        }

        @ParameterizedTest
        @ValueSource(strings = {
                "+++++"
                , "+"
                , "(", "()"
                , "1+" , "1+1+", "1++1"
                , "1()1"
        })
        void 계산식의_형식이_아니면_에러반환(String userInput) {

        }
    }
}
