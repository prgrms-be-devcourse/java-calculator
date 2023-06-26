package me.kimihiqq.utils;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormulaProcessorTest {

    @Test
    void shouldParseFormulaCorrectly() {
        // Arrange
        String formula = "3 + 2 * 2";

        // Act
        List<String> terms = FormulaProcessor.parseFormula(formula);

        // Assert
        assertEquals(Arrays.asList("3", "+", "2", "*", "2"), terms);
    }

    @Test
    void shouldThrowExceptionWhenFormulaIsInvalid() {
        // Arrange
        String formula = "3 + * 2";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> FormulaProcessor.validateFormula(formula));
    }
}