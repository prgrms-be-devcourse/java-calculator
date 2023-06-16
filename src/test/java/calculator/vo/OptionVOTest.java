package calculator.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionVOTest {

    @DisplayName("옵션이 1~2가 아닐 경우 예외가 발생한다.")
    @Test
    void 옵션_입력_예외() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new OptionVO("3"));
        assertThat(e.getMessage()).isEqualTo("유효하지 않은 옵션입니다");
    }

    @DisplayName("옵션이 1~2일 경우 정상적으로 동작한다.")
    @Test
    void 옵션_입력_정상_동작() {
        String[] options = {"1", "2"};

        for (String option : options) {
            OptionVO optionVO = new OptionVO(option);

            String result = optionVO.get();

            assertThat(result).isEqualTo(option);
        }

    }

}