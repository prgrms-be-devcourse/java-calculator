import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

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
    void 비정상_입력() {
        //given
        String input = "3";
        //when
        Option option = Option.find(input);
        //then
        Assertions.assertThat(option).isEqualByComparingTo(Option.CALCULATE);
    }
}