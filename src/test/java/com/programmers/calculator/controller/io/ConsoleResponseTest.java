package com.programmers.calculator.controller.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("ConsoleResponse 테스트")
class ConsoleResponseTest {

    @DisplayName("입력값 대로 생성된 객체의 getInput 메서드는 입력값을 그대로 반환한다")
    @Test
    void consoleResponseGetInputTest() {
        //given
        String inputValue = "input";
        //when
        ConsoleResponse consoleResponse = new ConsoleResponse(inputValue);
        //then
        assertEquals(inputValue, consoleResponse.result());
    }

}