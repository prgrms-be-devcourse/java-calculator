package calculator.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProblemVOTest {

    @DisplayName("연산자와 피연산자를 공백으로 구분하지 않을 경우 예외가 발생한다.")
    @Test
    void 문제_입력_예외1() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Problem("1+ 2 * 300"));
        assertThat(e.getMessage()).isEqualTo("잘못된 형식입니다");
    }

    @DisplayName("숫자와 연산자 외의 문자가 있는 경우 예외가 발생한다.")
    @Test
    void 문제_입력_예외2() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Problem("100 + &$@#$! ㅋㅋ"));
        assertThat(e.getMessage()).isEqualTo("잘못된 형식입니다");
    }

    @DisplayName("올바른 수학식이 아닐 경우 예외가 발생한다.")
    @Test
    void 문제_입력_예외3() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Problem("1 +* 300"));
        assertThat(e.getMessage()).isEqualTo("잘못된 형식입니다");
    }

    @DisplayName("올바른 형식일 경우 정상 동작한다.")
    @Test
    void 문제_입력_정상_동작() {
        String problem = "1 + 100 + 4 - 6 * 8 / 2";
        Problem problemVO = new Problem(problem);

        String result = problemVO.get();

        assertThat(result).isEqualTo(problem);
    }
}