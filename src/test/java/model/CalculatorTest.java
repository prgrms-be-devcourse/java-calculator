package model;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    public void 덧셈계산_성공() {
        //given
        String stringExpression = "1 + 2";
        Expression expression = new Expression(stringExpression);
        //when
        double resultNum = Calculator.calculate(expression);
        //then
        assertThat(resultNum).isEqualTo(3);
    }

    @Test
    public void 뺄셈계산_성공() {
        //given
        String stringExpression = "1 - 2";
        Expression expression = new Expression(stringExpression);
        //when
        double resultNum = Calculator.calculate(expression);
        //then
        assertThat(resultNum).isEqualTo(-1);
    }

    @Test
    public void 곱셈계산_성공() {
        //given
        String stringExpression = "1 * 2";
        Expression expression = new Expression(stringExpression);
        //when
        double resultNum = Calculator.calculate(expression);
        //then
        assertThat(resultNum).isEqualTo(2);
    }

    @Test
    public void 나눗셈계산_성공() {
        //given
        String stringExpression = "4 / 2";
        Expression expression = new Expression(stringExpression);
        //when
        double resultNum = Calculator.calculate(expression);
        //then
        assertThat(resultNum).isEqualTo(2);
    }

    @Test
    public void 우선순위_계산_성공() {
        //given
        List<String> stringExpression = Arrays.asList("4 + 9 / 3 - 1 + 2 * 10", "20 / 4 + 9 - 10 * 5 / 2");
        List<Expression> expressions = stringExpression
                .stream()
                .map(Expression::new)
                .collect(Collectors.toList());
        //when
        List<Double> resultNums = expressions
                .stream()
                .map(Calculator::calculate)
                .collect(Collectors.toList());
        //then
        assertThat(resultNums).containsExactly((double)26,(double)-11);
    }

    @Test
    public void 빈공백이_들어오면_오류가_발생한다(){
        //given
        String stringExpression = "";
        //when
        //then
        assertThatThrownBy(() -> new Expression(stringExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자와 숫자가 제대로 입력되지 않았습니다.");
    }

    @Test
    public void 연산자와_피연산자의_순서가_맞지않을때_오류가_발생한다(){
        //given
        String stringExpression = "* 1 - 2";
        //when
        //then
        assertThatThrownBy(() -> new Expression(stringExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자와 숫자가 제대로 입력되지 않았습니다.");
    }

    @Test
    public void 연산자_혹은_숫자이외에_다른문자가_입력되면_오류가_발생한다(){
        //given
        String stringExpression = "a 1 - 2";
        //when
        //then
        assertThatThrownBy(() -> new Expression(stringExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자 혹은 숫자만 입력해주세요");
    }
}