package programmers.java.calulator.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTest {

    @Test
    @DisplayName("숫자를 입력 받았을 때 true 반환하는지 확인하는 테스트")
    public void 숫자_입력_확인_테스트() {
        //given
        String n = "10";

        //when
        Number number = new Number(n);

        //then
        assertTrue(number.isValid());
    }

    @Test
    @DisplayName("문자를 입력 받았을 때 true 반환하는지 확인하는 테스트")
    public void whenTokenIsNotNumber_thenIsValidReturnsFalse() {
        //given
        String c = "a";

        //when
        Number number = new Number(c);

        //then
        assertFalse(number.isValid());
    }

    @Test
    @DisplayName("정수 문자가 변환이 잘 되는지 확인하는 테스트")
    public void whenTokenIsNumber_thenToIntReturnsCorrectValue() {
        //given
        String n = "10";

        //when
        Number number = new Number(n);

        //then
        assertEquals(10, number.toInt());
    }
}
