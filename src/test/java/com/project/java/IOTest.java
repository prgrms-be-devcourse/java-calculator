package com.project.java;

import com.project.java.engine.io.Console;
import com.project.java.engine.io.Input;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class IOTest {
    String GREETING = "번호를 입력해주세요.";
    Input input = new Console();

    @Test
    public void specialCharacterRegexTest() throws Exception {
        //given
        String str = "1a asd!@#$$!#@ !@#$@!#@!$# ____())() + 2 ! + 3#@ + 4 + 5 - 4124 21";
        String str2 = "1 + 2 - 3 + 3 * 3 *45 / 423";



        // when
        String validateResult = str.replaceAll("[^\\d+\\-*/\\s]","");
        String validateResult2 = str2.replaceAll("[^\\d+\\-*/\\s]","");

        //then
        Assertions.assertEquals(str.length() == validateResult.length(), false);
        Assertions.assertEquals(str2.length() == validateResult2.length(), true);
    }
}
