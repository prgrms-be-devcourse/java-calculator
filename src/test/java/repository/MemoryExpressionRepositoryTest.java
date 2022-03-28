package repository;

import model.Expression;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryExpressionRepositoryTest {
    ExpressionRepository expressionRepository = new MemoryExpressionRepository();

    @Test
    public void 수식_저장_성공(){
        //given
        Expression expression = new Expression("1 + 2");
        expression.setCalcResult((double)3);
        //when
        expressionRepository.save(expression);
        //then
        List<Expression> expressions = expressionRepository.findAll();
        Expression findExpression = expressions.get(0);
        assertThat(findExpression).isEqualTo(expression);
    }

}