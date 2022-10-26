package engine.compute;

import engine.compute.validator.ExpressionValidator;
import engine.model.Token;
import engine.compute.converter.ExpressionConverter;
import engine.compute.operate.OperateMachine;

import java.util.List;


public class Computer {

    private ExpressionValidator expressionValidator;
    private ExpressionConverter expressionConverter;
    private OperateMachine operateMachine;


    public Computer(ExpressionValidator expressionValidator, ExpressionConverter expressionConverter) {
        this.expressionValidator = expressionValidator;
        this.expressionConverter = expressionConverter;
        operateMachine = new OperateMachine(expressionValidator);
    }

    public String compute(String input) {
        List<Token> tokens = expressionConverter.convertUserInputToToken(input);

        List<Token> availTokens = expressionValidator.validateToken(tokens);

        List<Token> postFix = expressionConverter.convertToPostFix(availTokens);

        return operateMachine.doCalculate(postFix);
    }
}
