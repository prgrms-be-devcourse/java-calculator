import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateExpressionTests {

    @Test
    @DisplayName("괄호의 짝이 맞지 않는 경우 예외를 발생시킨다.")
    void validateExpressionWithParentheses() {

    }

    @Test
    @DisplayName("+-/*이외의 연산자를 사용한 경우 예외를 발생시킨다.")
    void validateExpressionWithOpcode(){

    }

    @Test
    @DisplayName("')'를 제외한 연산자로 끝나는 경우 예외를 발생시킨다.")
    void validateExpressionWithEndLetter(){

    }

    @Test
    @DisplayName("피연산자의 개수가 1개 이하인 경우 예외를 발생시킨다.")
    void validateExpressionWithNumberOfOperands(){

    }

    @Test
    @DisplayName("괄호 속 단항연산자가 있는 경우 예외를 발생시킨다.")
    void validateExpressionWithUnary(){

    }

    @Test
    @DisplayName("연산항의 개수가 2개 이하인 경우 예외를 발생시킨다.")
    void validateExpressionWithNumberOfOperatorsAndOperands(){

    }

}