package calculator.model.expression;

/**
* Expression 설명
* 연산자, 피연산자 토큰으로 구성된 수식을 표현하는 VO 객체
*
* 의도 설명 :
* 먼저 수식을 구성하는 토큰은 연산자, 피연산자, 두가지 밖에 없다고 생각했습니다.
* 예를 들어 1 + (2 / 3) 수식을 공백을 기준으로 토큰화 한다면 1, +, (, 2, /, 3, )
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
