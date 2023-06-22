package org.programmers.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("")
    @Test
    void validateFormulaSplit() {
        // given
        String inputMsg = "5 * 2 + 8 / 4 - 3";
        List<String> expectedFormulaList = Arrays.asList("5", "*", "2", "+", "8", "/", "4", "-", "3");

        // when
        List<String> formulaList = validator.validateFormulaSplit(inputMsg);

        // then
        Assertions.assertEquals(expectedFormulaList, formulaList);
    }

    @Test
    void validateFormula() {
        // given
        List<String> formulaList = Arrays.asList("5", "*", "2", "+", "8", "/", "4", "-", "3");

        // when
        boolean isValidFormula = validator.validateFormula(formulaList);

        // then
        Assertions.assertTrue(isValidFormula);
    }
}
