import com.programmers.engine.module.BasicCalculator;
import com.programmers.engine.module.convert.AnswerConverter;
import com.programmers.engine.module.convert.PostfixConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
public class CalculatorTest {
    BasicCalculator bc = new BasicCalculator();
    AnswerConverter ac = new AnswerConverter();
    PostfixConverter pc = new PostfixConverter();

    @DisplayName("계산기 테스트")
    @Test
    void basicCalculatorTest() {
        String str = "3 + 2 + 4 * 5 + 3 / 1";
        int result = bc.doCalculate(str);
        assertThat(result).isEqualTo(28);
    }

    @DisplayName("정답 변환기 테스트")
    @Test
    void answerConverterTest() {
        List<String> list = new ArrayList<>(Arrays.asList("3", "2", "+", "4", "5", "*", "+", "3", "1", "/", "+"));
        int answer = ac.convertPostfixToAnswer(list);
        assertThat(answer).isEqualTo(28);
    }

    @DisplayName("후위표기 변환기 테스트")
    @Test
    void postfixConverterTest() {
        String str = "3 + 2 + 4 * 5 + 3 / 1";
        List<String> list = pc.convertInfixToPostfix(str);
        List<String> ans = new ArrayList<>(Arrays.asList("3", "2", "+", "4", "5", "*", "+", "3", "1", "/", "+"));
        assertThat(list).isEqualTo(ans);
    }

}
