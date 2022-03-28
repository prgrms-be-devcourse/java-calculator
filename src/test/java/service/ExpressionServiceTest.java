package service;
import model.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.ExpressionRepository;
import repository.MemoryExpressionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionServiceTest {
    ExpressionRepository expressionRepository = new MemoryExpressionRepository();
    ExpressionService expressionService = new ExpressionService(expressionRepository);

    @Test
    public void 덧셈계산_성공() {
        //given
        String expression = "1 + 2";
        //when
        double resultNum = expressionService.calculateExpression(expression);
        //then
        assertThat(resultNum).isEqualTo(3);
    }

    @Test
    public void 뺄셈계산_성공() {
        //given
        String expression = "1 - 2";
        //when
        double resultNum = expressionService.calculateExpression(expression);
        //then
        assertThat(resultNum).isEqualTo(-1);
    }

    @Test
    public void 곱셈계산_성공() {
        //given
        String expression = "1 * 2";
        //when
        double resultNum = expressionService.calculateExpression(expression);
        //then
        assertThat(resultNum).isEqualTo(2);
    }

    @Test
    public void 나눗셈계산_성공() {
        //given
        String expression = "4 / 2";
        //when
        double resultNum = expressionService.calculateExpression(expression);
        //then
        assertThat(resultNum).isEqualTo(2);
    }

    @Test
    public void 우선순위_계산_성공() {
        //given
        List<String> expressions = Arrays.asList("4 + 9 / 3 - 1 + 2 * 10", "20 / 4 + 9 - 10 * 5 / 2");
        //when
        List<Double> resultNums = expressions
                .stream()
                .map(exp -> expressionService.calculateExpression(exp))
                .collect(Collectors.toList());
        //then
        assertThat(resultNums).containsExactly((double)26,(double)-11);
    }

    @Test
    public void 사칙연산_수행후_수식클래스에_값이_저장된다(){
        //given
        String exp = "4 + 9 / 3 - 1 + 2 * 10";
        Double resultNum = (double)26;
        Expression expression = new Expression(exp);
        expression.setCalcResult(resultNum);
        //when
        expressionService.calculateExpression(exp);
        List<Expression> allExpression = expressionService.findAllExpression();
        //then
        assertThat(allExpression.size()).isEqualTo(1);
        assertThat(allExpression.get(0).getExpression()).isEqualTo(exp);
        assertThat(allExpression.get(0).getCalcResult()).isEqualTo(resultNum);
    }

    @Test
    public void 빈공백이_들어오면_오류가_발생한다(){
        //given
        String expression = "";
        //when
        //then
        assertThatThrownBy(() -> expressionService.calculateExpression(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자와 숫자가 제대로 입력되지 않았습니다.");
    }

    @Test
    public void 연산자와_피연산자의_순서가_맞지않을때_오류가_발생한다(){
        //given
        String expression = "* 1 - 2";
        //when
        //then
        assertThatThrownBy(() -> expressionService.calculateExpression(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자와 숫자가 제대로 입력되지 않았습니다.");
    }

    @Test
    public void 연산자_혹은_숫자이외에_다른문자가_입력되면_오류가_발생한다(){
        //given
        String expression = "a 1 - 2";
        //when
        //then
        assertThatThrownBy(() -> expressionService.calculateExpression(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자 혹은 숫자만 입력해주세요");
    }
}