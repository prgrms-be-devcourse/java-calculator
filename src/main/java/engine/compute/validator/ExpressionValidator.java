package engine.compute.validator;

import engine.model.Token;

import java.util.List;

public interface ExpressionValidator {
    List<Token> getValidatedTokenList(List<Token> tokenList);

    boolean isNumber(Token token);

    boolean isOperator(Token token);

    boolean isCorrectOrder(List<Token> tokenList);
}
