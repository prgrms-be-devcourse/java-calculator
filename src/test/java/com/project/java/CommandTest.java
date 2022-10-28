package com.project.java;

import com.project.java.utils.MenuSelectCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    public void enumCommandTest() throws Exception {
        //given
        String input1 = "1";
        String input2 = "2";
        String input3 = "1++1";
        // when
        MenuSelectCommand retrieve = MenuSelectCommand.valueOfCommand(input1);
        MenuSelectCommand calculate = MenuSelectCommand.valueOfCommand(input2);
        //then
        Assertions.assertEquals(MenuSelectCommand.RETRIEVE, retrieve);
        Assertions.assertEquals(MenuSelectCommand.CALCULATE, calculate);
    }
}
