import Calculator.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @Test
    @DisplayName("+문자열로 +오퍼레이션을 불러온다")
    void _1() {
        String symbol = "+";
        Operation op = Operation.getOperation(symbol);
        assertThat(op.getType().equals(symbol));
    }

    @Test
    @DisplayName("*문자열로 *오퍼레이션을 불러온다")
    void _2() {
        String symbol = "*";
        Operation op = Operation.getOperation(symbol);
        assertThat(op.getType().equals(symbol));
    }

    @Test
    @DisplayName("-문자열로 -오퍼레이션을 불러온다")
    void _3() {
        String symbol = "-";
        Operation op = Operation.getOperation(symbol);
        assertThat(op.getType().equals(symbol));
    }

    @Test
    @DisplayName("/문자열로 /오퍼레이션을 불러온다")
    void _4() {
        String symbol = "/";
        Operation op = Operation.getOperation(symbol);
        assertThat(op.getType().equals(symbol));
    }

    @Test
    @DisplayName("1 + 2 = 3")
    void _5() {
        Operation add = Operation.ADD;
        long calc = add.calc(1, 2);
        assertThat(calc).isEqualTo(3);
    }

    @Test
    @DisplayName("2 * 3 = 6")
    void _6() {
        Operation add = Operation.MUL;
        long calc = add.calc(2, 3);
        assertThat(calc).isEqualTo(6);
    }

    @Test
    @DisplayName("1 - 2 = -1")
    void _7() {
        Operation add = Operation.MINUS;
        long calc = add.calc(1,  2);
        assertThat(calc).isEqualTo(-1 * 1);
    }

    @Test
    @DisplayName("4 / 2 = 2")
    void _8() {
        Operation add = Operation.DIV;
        long calc = add.calc(4, 2);
        assertThat(calc).isEqualTo(2);
    }

}