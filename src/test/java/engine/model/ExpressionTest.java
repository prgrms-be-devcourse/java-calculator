package engine.model;

import engine.compute.validator.ExpressionValidator;
import engine.compute.validator.SimpleExpressionValidator;
import engine.exception.NotValidInputException;
import engine.compute.converter.ExpressionConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ExpressionTest {
    private ExpressionValidator validator;
    private ExpressionConverter converter;

    @BeforeEach
    void setting() {
        validator = new SimpleExpressionValidator();
        converter = new ExpressionConverter(validator);
    }

    @Test
    void 후위식전환테스트() {
        List<Token> tokens = converter.convertUserInputToTokenList("3 * 5 - 4 / 2");
        List<Token> result = converter.convertToPostFix(tokens);

        StringBuilder sb = new StringBuilder();
        result.stream().forEach(postFixedToken -> sb.append(postFixedToken.getToken()));
        Assertions.assertEquals("35*42/-", sb.toString());
    }

    @Test
    void 후위식전환테스트2() {
        Assertions.assertThrowsExactly(NotValidInputException.class,
                () -> converter.convertUserInputToTokenList("3 * * 5 - 4 / 2"));
    }
}