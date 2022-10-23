package calculator.operation;

import calculator.validator.FormulaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class OperationManagerTest {

    OperationManager operationManager = new OperationManager(new FormulaValidator());

    @Test
    @DisplayName("연산")
    void test2() {

        //given
        List<String> origin = Arrays.asList("3", "2", "4", "*", "1", "-", "+");
        String answer = "10.0";

        //when
        String result = operationManager.calculate(origin);

        //then
        Assertions.assertEquals(result, answer);

    }

    @Test
    @DisplayName("후위 표기법 변환")
    void test1() {

        //given
        List<String> origin = Arrays.asList("3", "+", "2", "*", "4", "-", "1");
        List<String> expect = Arrays.asList("3", "2", "4", "*", "1", "-", "+");

        //when
        List<String> postFix = operationManager.toPostFix(origin);

        //then
        Assertions.assertEquals(postFix, expect);

    }
}