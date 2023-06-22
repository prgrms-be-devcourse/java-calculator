package calulator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calulator.domain.Expression.createExpression;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ExpressionTest {

    @DisplayName("우선 연산자를 적용해서 결과값을 도출한다.")
    @Test
    void calculateExpressionTest(){
        Expression expression = createExpression("1+2*3/3");
        String result = expression.calculate();

        assertThat(result).isEqualTo("3");
    }

}
