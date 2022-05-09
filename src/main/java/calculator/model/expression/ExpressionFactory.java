package calculator.model.expression;

import calculator.module.validator.exception.InvalidExpressionException;

/**
* ExpressionFactory
* 문자열 수식을 가공하여 Expression 객체를 생성해주는 클래스
**/
public class ExpressionFactory {
    private final static String OPERAND_OPERATOR_DELIMITER = " ";
    TokenTypeChecker tokenTypeChecker;

    public ExpressionFactory(TokenTypeChecker tokenTypeChecker) {
        this.tokenTypeChecker = tokenTypeChecker;
    }

    public Expression createExpression(String primitiveExpression) throws InvalidExpressionException {
        String[] primitiveTokens = primitiveExpression.split(OPERAND_OPERATOR_DELIMITER);
        ExpressionableToken[] typeCheckedTokens = tokenTypeChecker.createTypeCheckedToken(primitiveTokens);
        return new Expression(typeCheckedTokens);
    }
}
