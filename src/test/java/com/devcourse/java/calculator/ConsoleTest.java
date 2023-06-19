package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;
import com.devcourse.java.calculator.io.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConsoleTest {

    Console console = new Console();

    @Test
    @DisplayName("메뉴 선택 입력이 정수가 아닐 경우 InputMismatchException 확인")
    void getCommand_Input_Not_Integer() {
        //given
        String command1 = "abc";
        String command2 = ".~!,=";

        //when, then
        assertThatThrownBy(() -> InputValidator.checkCommandInput(command1))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.COMMAND_INPUT_NOT_INTEGER_EXCEPTION);

        assertThatThrownBy(() -> InputValidator.checkCommandInput(command2))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.COMMAND_INPUT_NOT_INTEGER_EXCEPTION);
    }

    @Test
    @DisplayName("메뉴 선택 입력이 정수지만 1~3이 아닐 경우 InputMismatchException 확인")
    void getCommand_Input_Not_In_Boundary() {
        //given
        String command1 = "99";
        String command2 = "30";

        //when, then
        assertThatThrownBy(() -> InputValidator.checkCommandInput(command1))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.COMMAND_INPUT_NOT_IN_BOUNDARY_EXCEPTION);

        assertThatThrownBy(() -> InputValidator.checkCommandInput(command2))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.COMMAND_INPUT_NOT_IN_BOUNDARY_EXCEPTION);
    }

    @Test
    @DisplayName("비어있는 계산 내역 조회할때 IllegalArgumentException 확인")
    void PrintCalculateHistory_Empty_Exception() {
        //given
        LinkedHashMap<Integer, String> history = new LinkedHashMap<>();

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
        LinkedHashMap<Integer, String> history = new LinkedHashMap<>();
        history.put(1, "1 + 2 = 3");
        history.put(2, "5 + 10 * 2 = 25");

        //when
        console.printCalculateHistory(history);
        String expectedOutput = "1 + 2 = 3\r\n5 + 10 * 2 = 25\r\n";

        //then
        assertThat(outputStream.toString()).isEqualTo(expectedOutput);

        System.setOut(System.out);
    }

    @Test
    @DisplayName("연산자 정규표현식 확인")
    void isOperatorTest() {
        //given
        String test1 = "+";
        String test2 = "++";
        String test3 = "+*";

        //when
        boolean result1 = InputValidator.isOperator(test1);
        boolean result2 = InputValidator.isOperator(test2);
        boolean result3 = InputValidator.isOperator(test3);

        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
        assertThat(result3).isEqualTo(false);

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
        assertThatThrownBy(() -> InputValidator.checkEquationInput(input))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);

        assertThatThrownBy(() -> InputValidator.checkEquationInput(input2))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);

        assertThatThrownBy(() -> InputValidator.checkEquationInput(input3))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);

        assertThatThrownBy(() -> InputValidator.checkEquationInput(input4))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
    }

    @Test
    @DisplayName("식 입력에 대한 확인")
    void getEquation_Valid_Test() {
        //given
        String input = "3 + 4 * 5";

        //when, then
        assertThatCode(() -> InputValidator.checkEquationInput(input))
                .doesNotThrowAnyException();
    }

}
