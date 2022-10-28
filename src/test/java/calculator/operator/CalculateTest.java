package calculator.operator;

import calculator.filter.Filter;
import calculator.filter.FilterImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    @DisplayName("곱셈과 나눗셈 우선순위 체크")
    @Test
    void isMultiplicationOrDivisionOK() {
        //given
        String s = "10 + 2 * 7 -1";
        Operator operator = new OperateManager();

        //when
        boolean result = operator.isMultiplyOrDivide(s);

        //then
        assertEquals(result, true);
    }

    @DisplayName("곱셈과 나눗셈이 없는 연산 우선순위 체크")
    @Test
    void isMultiplicationOrDivisionNO() {
        //given
        String s = "10 + 2 - 7 -1";
        Operator operator = new OperateManager();

        //when
        boolean result = operator.isMultiplyOrDivide(s);

        //then
        assertEquals(result, false);
    }

    @DisplayName("곱셈과 나눗셈 결과식")
    @Test
    void multiplicationOrDivision() {
        //given
        String s = "10+12*19-1/2*2/10";
        int resultLen = 5;
        Filter f = new FilterImpl();
        Stack<String> stack = f.changeStringToStack(s);
        Operator operator = new OperateManager();

        //when
        Stack<String> result = operator.multiplyOrDivide(stack);

        //then
        assertEquals(resultLen, result.size());
    }

    @DisplayName("최종 연산 결과")
    @Test
    void addOrSubtract() {
        //given
        String s = "10+12*19-1/2*2/10";
        double result = 237.9;
        Filter f = new FilterImpl();
        Stack<String> stack = f.changeStringToStack(s);
        Operator operator = new OperateManager();

        //when
        stack = operator.multiplyOrDivide(stack);
        double calculate = operator.addOrSubtract(stack);

        //then
        assertEquals(calculate, result);
    }
}