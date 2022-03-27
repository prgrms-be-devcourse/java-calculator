package com.programmers.cal.logic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CalculatorStoreTest {

    private CalculatorStore calculatorStore = new CalculatorStore(new ArrayList<>());
    private static final Formula VALID_FORMULA = new Formula("1 + 2", 3);
    private static final int VALID_INDEX = 0;
    private static final int VALID_SIZE = 10;

    @BeforeEach
    void setUp() {
        calculatorStore.selectAll().clear();
    }

    @Test
    @DisplayName("수식 클래스를 저정합니다.")
    void save() {
        // GIVEN
        String equation = "1 + 2";
        int result = 3;

        // WHEN
        Formula formula = new Formula(equation, result);
        calculatorStore.save(formula);

        // THEN
        Assertions.assertThat(calculatorStore
                        .selectAll()
                        .get(VALID_INDEX)
                        .toString())
                .isEqualTo(VALID_FORMULA.toString());
    }

    @Test
    @DisplayName("수식 클래스를 조회합니다.")
    void selectAll() {
        // GIVEN
        for (int i = 0; i < 10; i++) {
            calculatorStore.save(new Formula("1 + 2", 3.0));
        }

        // WHEN
        List<Formula> formulas = calculatorStore.selectAll();

        // THEN
        Assertions.assertThat(formulas).hasSize(VALID_SIZE);
    }

}
