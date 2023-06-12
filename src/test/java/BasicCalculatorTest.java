import com.programmers.BasicCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
public class BasicCalculatorTest {
    BasicCalculator bc = new BasicCalculator();
    @DisplayName("계산기 테스트")
    @Test
    void BasicCalculatorTest() {
        String str = "3 + 2 + 4 * 5 + 3 / 1";
        String result = bc.doCalculate(str);
        assertThat(result).isEqualTo("3 + 2 + 4 * 5 + 3 / 1 = 28");
    }

}
