import com.calculator.entity.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ExpressionTest {

    @Test
    @DisplayName("equals() 테스트")
    void e() {
        Expression e1 = new Expression("1 + 2", 3);
        Expression e2 = new Expression("1 + 2", 3);

        assertThat(e1.equals(e2)).isTrue();
    }
}
