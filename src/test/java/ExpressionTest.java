import com.calculator.entity.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @Test
    @DisplayName("equals() 테스트")
    void e() {
        Expression e1 = new Expression("1 + 2", "3");
        Expression e2 = new Expression("1 + 2", "3");

        assertThat(e1.equals(e2)).isTrue();
    }

    @Test
    @DisplayName("toString() 정규식 적용 테스트")
    void r() {
        Expression e1 = new Expression("1 + 2", "3.0");
        Expression e2 = new Expression("1 + 2.5", "3.5");

        assertThat(e1.toString()).isEqualTo("1 + 2 = 3");
        assertThat(e2.toString()).isEqualTo("1 + 2.5 = 3.5");
    }
}
