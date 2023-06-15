package Domain.Calculator;

import Common.Exception.DivideByZeroException;
import Common.Exception.WrongValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationTest {
    @Test
    @DisplayName("사칙연산 도출")
    void from() {
        //given
        String[] operations = {"+", "-", "*", "/"};
        // when
        // then
        assertThat(ArithmeticOperation.from(operations[0])).isEqualTo(ArithmeticOperation.ADD);
        assertThat(ArithmeticOperation.from(operations[1])).isEqualTo(ArithmeticOperation.SUB);
        assertThat(ArithmeticOperation.from(operations[2])).isEqualTo(ArithmeticOperation.MUL);
        assertThat(ArithmeticOperation.from(operations[3])).isEqualTo(ArithmeticOperation.DIV);
    }

    @Test
    @DisplayName("사칙연산 도출")
    void fromWhenWrongValue() {
        //given
        String[] operations = {"d", "!", "1", "x"};
        // when
        // then
        assertThrows(WrongValueException.class, () -> ArithmeticOperation.from(operations[0]));
        assertThrows(WrongValueException.class, () -> ArithmeticOperation.from(operations[1]));
        assertThrows(WrongValueException.class, () -> ArithmeticOperation.from(operations[2]));
        assertThrows(WrongValueException.class, () -> ArithmeticOperation.from(operations[3]));
    }

    @Test
    @DisplayName("0으로 나눴을 때")
    void calculateWhenDivideByZero() {
        // given
        ArithmeticOperation operation = ArithmeticOperation.from("/");
        Double operand1 = 10.0;
        Double operand2 = 0.0;
        // when
        // then
        assertThrows(DivideByZeroException.class, () -> operation.calculate(operand1, operand2));
    }
}