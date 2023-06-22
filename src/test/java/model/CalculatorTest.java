package model;

import exception.IllegalExpressionException;
import exception.NoSuchOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 비어있는 식이 들어올 경우")
    void throwExceptionIfEmptyExpression(String expression) {
        // then
        assertThatThrownBy(() -> calculator.calculate(expression))
                .isInstanceOf(IllegalExpressionException.class)
                .hasMessageContaining("[ERROR] 비어있는 식이 들어왔습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "13 15", "13 15 17", "+", "1 +", "1 -", "1 + 12 +"})
    @DisplayName("최종결과를 만드는 것이 불가능한 경우")
    void throwExceptionIfConsistOfOnlyOperand(String expression) {
        // then
        assertThatThrownBy(() -> calculator.calculate(expression))
                .isInstanceOf(IllegalExpressionException.class)
                .hasMessageContaining("[ERROR] 잘못된 식이 입력됐습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"* +", "* - /", "+ / - *"})
    @DisplayName("식에 연산자만 입력된 경우")
    void throwExceptionIfConsistOfOnlyOperator(String expression) {
        // then
        assertThatThrownBy(() -> calculator.calculate(expression))
                .isInstanceOf(IllegalExpressionException.class)
                .hasMessageContaining("[ERROR] 피연산자 스택에 수가 부족합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"////", "++++", "+-*", "----", ",", "=", "&^%%"})
    @DisplayName("잘못된 연산자가 입력된 경우")
    void throwExceptionIfNoValidOperator(String expression) {
        // then
        assertThatThrownBy(() -> calculator.calculate(expression))
                .isInstanceOf(NoSuchOperatorException.class)
                .hasMessageContaining("[ERROR] 옳지 않은 연산자입니다.");
    }

    // todo: 성공테스트 작성, 작성안한 나머지 테스트 작성, 종단 테스트 작성

}
