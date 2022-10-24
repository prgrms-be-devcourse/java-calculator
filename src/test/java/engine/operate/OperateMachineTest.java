package engine.operate;

import engine.compute.validator.ExpressionValidator;
import engine.compute.validator.SimpleExpressionValidator;
import engine.exception.NotValidInputException;
import engine.model.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class OperateMachineTest {

    OperateMachine machine;
    ExpressionFactory factory;
    ExpressionValidator validator;
    @BeforeEach
    void setting() {
        validator = new SimpleExpressionValidator();
        machine = new OperateMachine(validator);
        factory = new ExpressionFactory(validator);
    }


    @Test
    void 사칙연산테스트() {
        List<Token> tokens = factory.convertUserInputToToken("3*5 - 4/2");
        List<Token> postFix = factory.convertToPostFix(tokens);

        String result = machine.doCalculate(postFix);
        Assertions.assertEquals("13.00", result);
    }

    @Test
    void 사칙연산테스트2() {
        List<Token> tokens = factory.convertUserInputToToken("8 / 2 * 5 + 4 - 4 / 2 + 5");
        List<Token> postFix = factory.convertToPostFix(tokens);

        String result = machine.doCalculate(postFix);

        Assertions.assertEquals("27.00", result);
    }

    @Test
    void zero로나누는경우() {
        List<Token> tokens = factory.convertUserInputToToken("8 / 0");
        List<Token> postFix = factory.convertToPostFix(tokens);

        Assertions.assertThrowsExactly(NotValidInputException.class,
                () -> machine.doCalculate(postFix));
    }
}