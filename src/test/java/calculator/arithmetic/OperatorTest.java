package calculator.arithmetic;

import com.programmers.java.calculator.arithmetic.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    private final Operator operator = new Operator();

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("후위표기식을 계산 결과로 전환하기")
    public void convertPostfixToCalculationResult(List<String> postfix, String answer){
        assertThat(operator.getResult(postfix)).isEqualTo(answer);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList("1","3","8","*","+"), "25"),
                Arguments.of(Arrays.asList("2","5","*","7","-"), "3"),
                Arguments.of(Arrays.asList("8","2","/","3","-","3","2","*","+"), "7")
        );
    }
}
