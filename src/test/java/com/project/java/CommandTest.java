package com.project.java;

import com.project.java.utils.Command;
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
        Command retrieve = Command.valueOfCommand(input1);
        Command calculate = Command.valueOfCommand(input2);
        //then
        Assertions.assertEquals(Command.RETRIEVE, retrieve);
        Assertions.assertEquals(Command.CALCULATE, calculate);
    }
}
