package calculator.arithmetic;

import com.programmers.java.calculator.arithmetic.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParserTest {

    private final Parser parser = new Parser();

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("수식을 후위표기식 형태로 전환하기")
    public void convertToPostfix(String expression, List<String> answer) {
        assertThat(parser.parseToToken(expression)).isEqualTo(answer);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("1 + 3 * 8", Arrays.asList("1","3","8","*","+")),
                Arguments.of("2 * 5 - 7", Arrays.asList("2","5","*","7","-")),
                Arguments.of("8 / 2 - 3 + 3 * 2", Arrays.asList("8","2","/","3","-","3","2","*","+"))
        );
    }
}
