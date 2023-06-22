package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;
import com.devcourse.java.calculator.io.Console;
import com.devcourse.java.calculator.validator.equationValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConsoleTest {

    Console console = new Console();

    @Test
    @DisplayName("비어있는 계산 내역 조회할때 IllegalArgumentException 확인")
    void PrintCalculateHistory_Empty_Exception() {
        //given
        List<String> history = new ArrayList<>();

        //when, then
        assertThatThrownBy(() -> console.printCalculateHistory(history))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessageConstant.EMPTY_CALCULATE_HISTORY_EXCEPTION);

    }

    @Test
    @DisplayName("계산 내역 조회 확인")
    void PrintCalculateHistory_Test() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //given
        List<String> history = new ArrayList<>();
        history.add("1 + 2 = 3");
        history.add( "5 + 10 * 2 = 25");

        //when
        console.printCalculateHistory(history);
        String expectedOutput = "1 + 2 = 3\r\n5 + 10 * 2 = 25\r\n";

        //then
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);

        System.setOut(System.out);
    }



    @Test
    @DisplayName("올바르지 못한 식 입력에 대한 InputMismatchException 확인")
    void getEquation_Invalid_Test() {
        //given
        String input = "3 + 4 *";
        String input2 = "";
        String input3 = "3 + + 1";
        String input4 = "1 2 3";

        //when, then
        assertThatThrownBy(() -> equationValidator.checkEquationInput(input))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);

        assertThatThrownBy(() -> equationValidator.checkEquationInput(input2))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);

        assertThatThrownBy(() -> equationValidator.checkEquationInput(input3))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);

        assertThatThrownBy(() -> equationValidator.checkEquationInput(input4))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
    }

    @Test
    @DisplayName("식 입력에 대한 확인")
    void getEquation_Valid_Test() {
        //given
        String input = "3 + 4 * 5";

        //when, then
        assertThatCode(() -> equationValidator.checkEquationInput(input))
                .doesNotThrowAnyException();
    }

}
