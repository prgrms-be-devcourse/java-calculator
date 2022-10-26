package engine.compute;

import engine.compute.validator.ExpressionValidator;
import engine.model.Token;
import engine.compute.converter.ExpressionConverter;
import engine.compute.operate.OperateMachine;

import java.util.List;


public class Computer {

    private final ExpressionValidator expressionValidator;
    private final ExpressionConverter expressionConverter;
    private final OperateMachine operateMachine;


    public Computer(ExpressionValidator expressionValidator, ExpressionConverter expressionConverter) {
        this.expressionValidator = expressionValidator;
        this.expressionConverter = expressionConverter;
        operateMachine = new OperateMachine(expressionValidator);
    }

    public String compute(String input) {
        List<Token> tokens = expressionConverter.convertUserInputToTokenList(input);

        List<Token> validatedTokenList = expressionValidator.getValidatedTokenList(tokens);

        List<Token> postFix = expressionConverter.convertToPostFix(validatedTokenList);

        return operateMachine.doCalculate(postFix);
    }
}
