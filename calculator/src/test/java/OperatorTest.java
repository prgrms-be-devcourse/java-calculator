import model.Operator;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void 정상_입력() {
        //given
        String plusOperation = "+";
        String minusOperation = "-";
        String multiplyOperation = "*";
        String divideOperation = "/";
        //when
        Operator plus = Operator.parse(plusOperation);
        Operator minus = Operator.MINUS;
        Operator multiply = Operator.MULTIPLY;
        Operator divide = Operator.DIVIDE;
        //then
        Double calculate = plus.calculate(1, 2);

    }
}