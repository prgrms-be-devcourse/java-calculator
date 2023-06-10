package org.calculator.engine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConditionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "%"})
    @DisplayName("Condition이 정상적으로 반환 되는지 조회")
    void decideCondition(String condition) {
        Optional<Condition> optionalCondition = Condition.decideCondition(condition);
        switch (condition) {
            case "1" -> assertThat(optionalCondition.get()).isEqualTo(Condition.LOOKUP);
            case "2" -> assertThat(optionalCondition.get()).isEqualTo(Condition.CALCULATE);
            case "3" -> assertThat(optionalCondition.get()).isEqualTo(Condition.BREAK);
            default -> assertThat(optionalCondition).isEmpty();
        }
    }
}
