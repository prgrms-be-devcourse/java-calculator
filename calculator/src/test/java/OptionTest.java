import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

import java.util.NoSuchElementException;

class OptionTest {

    @Test
    void 정상_입력() {
        //given
        String input = "1";
        //when
        Option option = Option.find(input);
        //then
        Assertions.assertThat(option).isEqualByComparingTo(Option.INQUIRY);
    }

    @Test
    void _12가_아닌_숫자를_입력() {
        //given
        String input = "3";
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Option.find(input));

    }

    @Test
    void _숫자가_아닌_문자를_입력() {
        //given
        String input = "a";
        //then
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Option.find(input));
    }
}