import com.programmers.engine.model.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OperatorTest {
    @DisplayName("우선순위 테스트")
    @Test
    void getPriorityTest() {
        assertThat(Operator.matchOperator("+").getPriority()).isEqualTo(1);
        assertThat(Operator.matchOperator("-").getPriority()).isEqualTo(1);
        assertThat(Operator.matchOperator("*").getPriority()).isEqualTo(2);
        assertThat(Operator.matchOperator("/").getPriority()).isEqualTo(2);
    }

    @DisplayName("사칙연산 테스트")
    @Test
    void calculateTest() {
        assertThat(Operator.ADD.calculate(2, 6)).isEqualTo(8);
        assertThat(Operator.SUBTRACTION.calculate(2, 6)).isEqualTo(-4);
        assertThat(Operator.MULTIPLY.calculate(2, 6)).isEqualTo(12);
        assertThat(Operator.DIVIDE.calculate(2, 6)).isEqualTo(3);
    }
}
