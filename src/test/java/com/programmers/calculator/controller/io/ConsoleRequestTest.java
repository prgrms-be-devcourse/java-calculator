package com.programmers.calculator.controller.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ConsoleRequest 테스트")
class ConsoleRequestTest {

    @DisplayName("입력값 대로 생성된 객체의 getInput 메서드는 입력값을 그대로 반환한다")
    @Test
    void consoleRequestGetInputTest() {
        //given
        String inputValue = "input";
        //when
        ConsoleRequest consoleRequest = new ConsoleRequest(inputValue);
        //then
        assertEquals(inputValue, consoleRequest.getInput());
    }

}