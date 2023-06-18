package com.devcourse.java.domain.mapper;

import com.devcourse.java.domain.operator.Division;
import com.devcourse.java.domain.operator.Minus;
import com.devcourse.java.domain.operator.Multiply;
import com.devcourse.java.domain.operator.Operator;
import com.devcourse.java.domain.operator.OperatorMapper;
import com.devcourse.java.domain.operator.Plus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OperatorMapperTest {
    private OperatorMapper factory = new OperatorMapper();

    @ParameterizedTest
    @DisplayName("연산자 symbol에 맞게 연산자를 리턴해야 한다.")
    @MethodSource("data")
    void operatorPriorityTest(String symbol, Class<? extends Operator> operator) {
        // given

        // when
        Operator createdOperator = factory.toOperator(symbol);

        // then
        assertThat(createdOperator).isInstanceOf(Operator.class);
        assertThat(createdOperator).isInstanceOf(operator);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("+", Plus.class),
                arguments("-", Minus.class),
                arguments("*", Multiply.class),
                arguments("/", Division.class)
        );
    }
}
