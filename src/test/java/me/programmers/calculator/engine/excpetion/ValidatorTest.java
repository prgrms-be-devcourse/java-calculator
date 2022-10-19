package me.programmers.calculator.engine.excpetion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    void emptyProblemTest() {
        String problem = "";

        assertThrows(InputException.class, () -> {
            validator.problemValidate(problem);
        });
    }

    @Test
    void frontOperatorProblemTest() {
        String problem = "*1+2";

        assertThrows(InputException.class, () -> {
            validator.problemValidate(problem);
        });
    }

    @Test
    void backOperatorProblemTest() {
        String problem = "1+2*";

        assertThrows(InputException.class, () -> {
            validator.problemValidate(problem);
        });
    }

    @Test
    void wrongOperatorProblemTest() {
        String problem = "1.4";

        assertThrows(InputException.class, () -> {
            validator.problemValidate(problem);
        });
    }

    @Test
    void doubleOperatorProblemTest() {
        String problem = "1 +- 4";

        assertThrows(InputException.class, () -> {
            validator.problemValidate(problem);
        });
    }

}