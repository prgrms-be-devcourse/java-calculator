package test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import src.calculation.Calculator;
import src.exception.ErrorMessage;

import static org.assertj.core.api.Assertions.*;



public class CalculatorTest {
    @Test
    @DisplayName("정수 연산 결과를 출력합니다.")
    public void calculate1(){
        //given
        //when
        String result = Calculator.calculate("1 + 2");
        //then
        assertThat(result).isEqualTo("3");
    }

    @Test
    @DisplayName("정수 연산 결과를 출력합니다.")
    public void calculate2(){
        //given
        //when
        String result = Calculator.calculate("1 + 2 * 3 / 5");

        //then
        assertThat(result).isEqualTo("2.2");
    }

    @Test
    @DisplayName("실수 연산 결과를 출력합니다.")
    public void calculate3(){
        //given
        //when
        String result = Calculator.calculate("2.4 * 3.2");

        //then
        assertThat(result).isEqualTo("7.68");
    }

    @Test
    @DisplayName("0으로 나눌 경우 예외가 발생합니다.")
    public void calculateWithDivideZero(){
        assertThatThrownBy(() -> Calculator.calculate("1 + 2 * 3 / 0"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.DIVIDE_BY_ZERO.getMessage());
    }
    @Test
    @DisplayName("계산식 중간에 들어가는 공백은 예외를 발생시킵니다.")
    public void calculateWithEmpty(){
        assertThatThrownBy(() -> Calculator.calculate("1 +   2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_EXPRESSION.getMessage());
    }
    @Test
    @DisplayName("계산식 끝에 들어가는 공백은 예외를 발생 시키지않습니다.")
    public void calculateWithEndEmpty(){
        //given
        //when
        String result = Calculator.calculate("1 + 2 ");
        //then
        assertThat(result).isEqualTo("3");
    }
    @Test
    @DisplayName("피연산자가 존재하지 않는 계산식은 예외를 발생시킵니다.")
    public void calculateInvalid1(){
        assertThatThrownBy(() -> Calculator.calculate("1 + 2 *"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.NOT_FOUND_OPERAND.getMessage());
    }
    @Test
    @DisplayName("연산자를 연이어 사용한 계산식은 예외를 발생시킵니다.")
    public void calculateInvalid2(){
        assertThatThrownBy(() -> Calculator.calculate("1 + 2 ** "))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_EXPRESSION.getMessage());
    }

    @Test
    @DisplayName("연산자를 연이어 사용한 계산식은 예외를 발생시킵니다.")
    public void calculateInvalid3(){
        assertThatThrownBy(() -> Calculator.calculate("1 ++ 2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_EXPRESSION.getMessage());
    }
    @Test
    @DisplayName("계산식에 특수문자가 포함 된 경우 예외를 발생시킵니다.")
    public void calculateInvalid4(){
        assertThatThrownBy(() -> Calculator.calculate("1 # 2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_EXPRESSION.getMessage());
    }
    @Test
    @DisplayName("계산식에 특수문자가 포함 된 경우 예외를 발생시킵니다.")
    public void calculateInvalid5(){
        assertThatThrownBy(() -> Calculator.calculate("1 + 2 ( ) ^ & %"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_EXPRESSION.getMessage());

    }
    @Test
    @DisplayName("계산식에 영문자가 포함 된 경우 예외를 발생시킵니다.")
    public void calculateInvalid6(){
        assertThatThrownBy(() -> Calculator.calculate("1 + 2 d df sdf"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_EXPRESSION.getMessage());
    }
    @Test
    @DisplayName("계산식이 빈 값일 경 예외를 발생시킵니다.")
    public void calculateEmpty1(){
        assertThatThrownBy(() -> Calculator.calculate(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.EMPTY_EXPRESSION.getMessage());
    }
    @Test
    @DisplayName("계산식이 공백일 경우 예외를 발생시킵니다.")
    public void calculateEmpty2(){
        assertThatThrownBy(() -> Calculator.calculate(" "))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.EMPTY_EXPRESSION.getMessage());

    }


    @Test
    @DisplayName("계산식이 null일 경우 예외를 발생시킵니다.")
    public void calculateNULL(){
        assertThatThrownBy(() -> Calculator.calculate(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.EMPTY_EXPRESSION.getMessage());
    }
}