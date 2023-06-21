package org.example.util;

import org.assertj.core.api.Assertions;
import org.example.exception.BadEquationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CheckEquationTest {

    @Test
    public void 잘못된_연산자_예외처리_테스트(){
        BadEquationException e = assertThrows(BadEquationException.class, () -> CheckEquation.validate("5 + 6 @ 9"));
        assertThat(e.getMessage()).isEqualTo("잘못된 수식이 입력 되었습니다.");
    }

    @Test
    public void 수식의_첫번째_값이_연산자일_경우_예외처리_테스트(){
        BadEquationException e = assertThrows(BadEquationException.class, () -> CheckEquation.validate("+ 7 * 9"));
        assertThat(e.getMessage()).isEqualTo("잘못된 수식이 입력 되었습니다.");
    }

    @Test
    public void 수식의_마지막_값이_연산자일_경우_예외처리_테스트(){
        BadEquationException e = assertThrows(BadEquationException.class, () -> CheckEquation.validate("5 * 7 +"));
        assertThat(e.getMessage()).isEqualTo("잘못된 수식이 입력 되었습니다.");
    }

    @Test
    public void 연속된_연산자_예외처리_테스트(){
        BadEquationException e = assertThrows(BadEquationException.class, () -> CheckEquation.validate("5 + + 9"));
        assertThat(e.getMessage()).isEqualTo("잘못된 수식이 입력 되었습니다.");
    }

}
