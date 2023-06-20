package com.devcourse.java.calculator.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {

    @Test
    @DisplayName("메뉴 선택 입력이 정수가 아닐 경우 InputMismatchException 확인")
    void getCommand_Input_Not_Integer() {
        //given
        String command1 = "abc";
        String command2 = ".~!,=";

        //when, then
        assertThatThrownBy(() -> Menu.checkCommandInput(command1))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.COMMAND_INPUT_NOT_INTEGER_EXCEPTION);

        assertThatThrownBy(() -> Menu.checkCommandInput(command2))
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
        assertThatThrownBy(() -> Menu.checkCommandInput(command1))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.COMMAND_INPUT_NOT_IN_BOUNDARY_EXCEPTION);

        assertThatThrownBy(() -> Menu.checkCommandInput(command2))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining(ExceptionMessageConstant.COMMAND_INPUT_NOT_IN_BOUNDARY_EXCEPTION);
    }

}