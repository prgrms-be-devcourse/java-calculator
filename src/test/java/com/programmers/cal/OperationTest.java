package com.programmers.cal;

import com.programmers.cal.engine.operation.Operation;
import com.programmers.cal.engine.operation.OperationManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    Operation operation = new OperationManager();

    @Test
    @DisplayName("연산 성공")
    public void successCalculate() {
        //given
        List<String> input1 = Arrays.asList("12", "3", "45", "*", "2", "/", "+");
        List<String> input2 = Arrays.asList("12", "-34", "2", "*", "+");
        List<String> input3 = Arrays.asList("-12", "-32", "-4", "/", "+");
        List<String> input4 = Arrays.asList("-12", "-32", "-4", "/", "+", "32", "2", "*", "+");

        String expected1 = "79.5";
        String expected2 = "-56.0";
        String expected3 = "-4.0";
        String expected4 = "60.0";

        //when
        String result1 = operation.calculate(input1);
        String result2 = operation.calculate(input2);
        String result3 = operation.calculate(input3);
        String result4 = operation.calculate(input4);

        //then
        assertThat(result1).isEqualTo(expected1);
        assertThat(result2).isEqualTo(expected2);
        assertThat(result3).isEqualTo(expected3);
        assertThat(result4).isEqualTo(expected4);
    }
}
