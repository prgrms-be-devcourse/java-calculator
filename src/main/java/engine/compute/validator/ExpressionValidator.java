package engine.compute.validator;

import engine.model.Token;

import java.util.List;

public interface ExpressionValidator {
    List<Token> validateToken(List<Token> tokenList);

    boolean isNumber(Token token);

    boolean isOperator(Token token);

    boolean isCorrectOrder(List<Token> tokenList);
}
