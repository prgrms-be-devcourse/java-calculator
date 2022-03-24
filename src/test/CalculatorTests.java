import exception.CalculatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTests {

    @Test
    @DisplayName("사칙연산의 우선순위에 따른 계산을 한다.")
    void calculateWithPriority(){

    }

    @Test
    @DisplayName("계산이력을 저장한다")
   void saveHistory(){

    }

    @Test
    @DisplayName("계산이력을 저장한 순서대로 출력한다.")
    void printHistory(){

    }

    @Test
    @DisplayName("괄호 속 단항연산자가 있는 경우 예외를 발생시킨다.")
    void validateExpressionWithUnary() {

        // given
        String exp1 = "(+1)";
        String exp2 = "1 + 2 +(-3)";
        String exp3 = "1 *(3)";
        // when

        // then
        Exception exception = assertThrows(CalculatorException.class, () -> {
        });
        assertEquals("올바르지 않은 연산식입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> {
        });
        assertEquals("올바르지 않은 연산식입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> {
        });
        assertEquals("올바르지 않은 연산식입니다.", exception.getMessage());

    }

}
