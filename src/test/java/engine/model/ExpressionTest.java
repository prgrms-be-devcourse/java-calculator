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
    ExpressionValidator validator;
    ExpressionConverter converter;

    @BeforeEach
    void setting() {
        validator = new SimpleExpressionValidator();
        converter = new ExpressionConverter(validator);
    }

    @Test
    void 후위식전환테스트() {
        List<Token> tokens = converter.convertUserInputToToken("3 * 5 - 4 / 2"); // 13
        List<Token> result = converter.convertToPostFix(tokens);

        result.stream().forEach(i -> System.out.println(i.getToken()));
    }

    @Test
    void 후위식전환테스트2() {
        Assertions.assertThrowsExactly(NotValidInputException.class,
                () -> converter.convertUserInputToToken("3 * * 5 - 4 / 2"));
    }

    @Test
    void 후위식전환테스트3() {
        List<Token> tokens = converter.convertUserInputToToken("3 / 5 * 4 + 2");
        List<Token> result = converter.convertToPostFix(tokens);

        result.stream().forEach(i -> System.out.println(i.getToken()));
    }
}