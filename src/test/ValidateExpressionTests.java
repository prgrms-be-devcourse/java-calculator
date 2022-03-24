import exception.CalculatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidateExpressionTests {

    private final ExpressionConverter converter = new Prefix2PostfixConverter();

    @Test
    @DisplayName("괄호의 짝이 맞지 않는 경우 예외를 발생시킨다.")
    void validateExpressionWithParentheses() {

        // given
        String exp1 = "1 + ( 3 * ( 4 - 2 )";
        String exp2 = "(()";
        String exp3 = "(3))";
        // when

        // then
        Exception exception = assertThrows(CalculatorException.class, () -> converter.convert(exp1));
        assertEquals("괄호의 짝이 맞지 않는 연산식입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp2));
        assertEquals("괄호의 짝이 맞지 않는 연산식입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp3));
        assertEquals("괄호의 짝이 맞지 않는 연산식입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("+-/*이외의 연산자를 사용한 경우 예외를 발생시킨다.")
    void validateExpressionWithOpcode() {
        // given
        String exp1 = "1 = 3";
        String exp2 = "1 + [ 2 + 3 ]";
        String exp3 = "1 % 3";
        // when

        // then
        Exception exception = assertThrows(CalculatorException.class, () -> converter.convert(exp1));
        assertEquals("피연산자가 범위를 초과했거나 지원하지 않는 연산자가 포함되어 있습니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp2));
        assertEquals("피연산자가 범위를 초과했거나 지원하지 않는 연산자가 포함되어 있습니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp3));
        assertEquals("피연산자가 범위를 초과했거나 지원하지 않는 연산자가 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("'('를 제외한 연산자로 시작하는 경우 예외를 발생시킨다.")
    void validateExpressionWithFirstLetter() {

        // given
        String exp1 = "+1 + 1";
        String exp2 = "-1 * (2 + 3)";
        String exp3 = "* 1 - 1";
        // when

        // then
        Exception exception = assertThrows(CalculatorException.class, () -> converter.convert(exp1));
        assertEquals("연산자로 시작하는 올바르지 않은 연산식 입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp2));
        assertEquals("연산자로 시작하는 올바르지 않은 연산식 입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp3));
        assertEquals("연산자로 시작하는 올바르지 않은 연산식 입니다.", exception.getMessage());

    }

    @Test
    @DisplayName("')'를 제외한 연산자로 끝나는 경우 예외를 발생시킨다.")
    void validateExpressionWithEndLetter() {

        // given
        String exp1 = "1 + +";
        String exp2 = "1 + 2 - (";
        String exp3 = "1 * 2 *";
        // when

        // then
        Exception exception = assertThrows(CalculatorException.class, () -> converter.convert(exp1));
        assertEquals("연산자로 끝난 올바르지 않은 연산식 입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp2));
        assertEquals("연산자로 끝난 올바르지 않은 연산식 입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp3));
        assertEquals("연산자로 끝난 올바르지 않은 연산식 입니다.", exception.getMessage());

    }


    @Test
    @DisplayName("공백이거나 연산항의 개수가 2개 이하인 경우 예외를 발생시킨다.")
    void validateExpressionWithNumberOfOperatorsAndOperands() {

        // given
        String exp1 = "";
        String exp2 = "1 1";
        String exp3 = "   ";
        // when

        // then
        Exception exception = assertThrows(CalculatorException.class, () -> converter.convert(exp1));
        assertEquals("적어도 3개의 연산항이 필요합니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp2));
        assertEquals("적어도 3개의 연산항이 필요합니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> converter.convert(exp3));
        assertEquals("적어도 3개의 연산항이 필요합니다.", exception.getMessage());

    }
}