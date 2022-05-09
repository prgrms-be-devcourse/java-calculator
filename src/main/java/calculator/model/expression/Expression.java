package calculator.model.expression;

/**
* Expression 설명
* 연산자, 피연산자 토큰으로 구성된 수식을 표현하는 VO 객체
**/

public class Expression {
    private final ExpressionableToken[] tokenArray;

    public Expression(ExpressionableToken[] tokenArray) {
        this.tokenArray = tokenArray;
    }

    public ExpressionableToken[] getTokenArray() {
        return tokenArray;
    }
}
