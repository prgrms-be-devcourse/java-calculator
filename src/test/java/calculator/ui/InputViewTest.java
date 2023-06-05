package calculator.ui;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest {

    @Nested
    class checkMenu_테스트 {


        @ParameterizedTest
        @ValueSource(strings = {
                 ""
                ,"abc"
                ,
        })
        void 메뉴번호가_1_2가_아니면_에러반환() {
        }
    }

    @Nested
    class equation_테스트 {
        @ParameterizedTest
        @ValueSource(strings = {
                ""
                ," "
        })
        void 계산식의_입력이_들어오지않는다면_에러반환() {

        }

        @ParameterizedTest
        @ValueSource(strings = {
                "+"
        })
        void 계산식의_입력에_숫자와_사칙연산_괄호가_아니면_에러반환() {

        }

        @ParameterizedTest
        @ValueSource(strings = {
                "+++++"
                , "+"
                , "(", "()"
                , "1+" , "1+1+", "1++1"
                , "1()1"
        })
        void 계산식의_형식이_아니면_에러반환() {

        }
    }
}
