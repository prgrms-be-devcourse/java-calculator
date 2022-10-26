package com.programmers.calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Command Enum Test")
class CommandTest {

    @DisplayName("커맨드 생성 테스트 - 문자열 1 파라미터는 INQUERY가 생성된다.")
    @Test
    void createCommandSuccessInput1ReturnINQUERY() {
        //given
        String input = "1";

        //when
        Command command = Command.of(input);

        //then
        assertEquals(Command.INQUIRY, command);
    }

    @DisplayName("커맨드 생성 테스트 - 문자열 2 파라미터는 CALCULATION가 생성된다.")
    @Test
    void createCommandSuccessInput2ReturnINQUERY() {
        //given
        String input = "2";

        //when
        Command command = Command.of(input);

        //then
        assertEquals(Command.CALCULATION, command);
    }

    @DisplayName("커맨드 생성 테스트 - 문자열 0 파라미터는  EXIT가 생성된다.")
    @Test
    void createCommandSuccessInput3ReturnEXIT() {
        //given
        String input = "0";

        //when
        Command command = Command.of(input);

        //then
        assertEquals(Command.EXIT, command);
    }

    @DisplayName("커맨드 생성 실패 테스트 - 필드로 가지고 있는 숫자값이 아니라면 생성에 실패한다")
    @Test
    void createCommandSuccessFail() {
        //given
        String input = "-1";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> Command.of(input));
    }

    @DisplayName("canCreate() 테스트 - 파라미터 정수 값으로 커맨드를 생성할 수 있으면 true를 리턴한다")
    @Test
    void canCreateWithIntegerParam() {
        //given
        int selectNumber = 1;

        //when
        boolean isCanCreate = Command.canCreate(selectNumber);

        //then
        assertTrue(isCanCreate);
    }

    @DisplayName("canCreate() 테스트 - 파라미터 정수 값으로 커맨드를 생성할 수 있으면 false를 리턴한다")
    @Test
    void cantCreateWithIntegerParam() {
        //given
        int selectNumber = -1;

        //when
        boolean isCanCreate = Command.canCreate(selectNumber);

        //then
        assertFalse(isCanCreate);
    }

}