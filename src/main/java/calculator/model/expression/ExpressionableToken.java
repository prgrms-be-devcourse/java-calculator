package calculator.model.expression;
/**
* ExpressionableToken 설명
* 수식에서 사용될 수 있는 토큰임을 나타내는 인터페이스
**/
public interface ExpressionableToken {
    boolean couldOtherTokenComeNext(ExpressionableToken other);
    String getValue();
}
