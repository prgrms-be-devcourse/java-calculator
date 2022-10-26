package engine.operate;

import engine.compute.converter.ExpressionConverter;
import engine.compute.operate.OperateMachine;
import engine.compute.validator.ExpressionValidator;
import engine.compute.validator.SimpleExpressionValidator;
import engine.exception.NotValidInputException;
import engine.model.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class OperateMachineTest {

    private OperateMachine machine;
    private ExpressionConverter converter;
    private ExpressionValidator validator;

    @BeforeEach
    void setting() {
        validator = new SimpleExpressionValidator();
        machine = new OperateMachine(validator);
        converter = new ExpressionConverter(validator);
    }


    @Test
    void 사칙연산테스트() {
        List<Token> tokens = converter.convertUserInputToTokenList("3*5 - 4/2");
        List<Token> postFix = converter.convertToPostFix(tokens);

        String result = machine.doCalculate(postFix);
        Assertions.assertEquals("13.00", result);
    }

    @Test
    void 사칙연산테스트2() {
        List<Token> tokens = converter.convertUserInputToTokenList("8 / 2 * 5 + 4 - 4 / 2 + 5");
        List<Token> postFix = converter.convertToPostFix(tokens);

        String result = machine.doCalculate(postFix);

        Assertions.assertEquals("27.00", result);
    }

    @Test
    void zero로나누는경우() {
        List<Token> tokens = converter.convertUserInputToTokenList("8 / 0");
        List<Token> postFix = converter.convertToPostFix(tokens);

        Assertions.assertThrowsExactly(NotValidInputException.class,
                () -> machine.doCalculate(postFix));
    }
}