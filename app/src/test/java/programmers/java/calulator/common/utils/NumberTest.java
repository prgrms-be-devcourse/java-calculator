package programmers.java.calulator.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTest {

    @Test
    @DisplayName("숫자를 입력 받았을 때 유효한 값을 반환하는지 확인하는 테스트")
    public void 숫자_입력_확인_테스트() {
        //given
        String n = "10";

        //when
        Optional<Number> number = Number.of(n);

        //then
        assertTrue(number.isPresent());
    }

    @Test
    @DisplayName("문자를 입력 받았을 때 유효하지 않은 값을 반환하는지 확인하는 테스트")
    public void 문자_입력_확인_테스트() {
        //given
        String c = "a";

        //when
        Optional<Number> number = Number.of(c);

        //then
        assertFalse(number.isPresent());
    }

    @Test
    @DisplayName("정수 문자가 변환이 잘 되는지 확인하는 테스트")
    public void 문자_변환_테스트() {
        //given
        String n = "10";

        //when
        Optional<Number> number = Number.of(n);

        //then
        assertEquals(10, number.get().toInt());
    }
}
