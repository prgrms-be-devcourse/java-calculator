import model.Option;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

import java.util.NoSuchElementException;

class OptionTest {

    @Test
    void 정상_입력() {
        //given
        String input = "1";
        //when
        Option option = Option.parse(input);
        //then
        Assertions.assertThat(option).isEqualByComparingTo(Option.INQUIRY);
    }

    @Test
    void _12가_아닌_숫자를_입력() {
        //given
        String input = "3";
        //then
        Assertions.assertThatThrownBy(() -> Option.parse(input))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("1,2 중 선택해야 합니다");

    }

    @Test
    void _숫자가_아닌_문자를_입력() {
        //given
        String input = "a";
        //then
        Assertions.assertThatThrownBy(() -> Option.parse(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자를 입력해야 합니다.");
    }
}