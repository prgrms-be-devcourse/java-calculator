package calculator.model.expression;

import calculator.AppConfig;
import calculator.model.token.TokenFactory;
import calculator.model.token.Tokenizationable;
import calculator.module.validator.exception.InvalidTokenException;

public class ExpressionFactory {
    private final TokenFactory tokenFactory;

    public ExpressionFactory(TokenFactory tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    public Expression createExpression(String expression) throws InvalidTokenException {
        String[] tokens = expression.split(AppConfig.OPERAND_OPERATOR_DELIMITER);
        Tokenizationable[] validTokens = tokenFactory.makeToken(tokens);
        return new Expression(validTokens);
    }

}
