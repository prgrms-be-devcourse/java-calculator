package com.programmers.java.engine.io;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleTest {
    Console console = new Console();

    @Test
    public void Input_String들어오면_잘못된_입력입니다_출력해야함() {
        //given
        String s = "Input";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        console.Error(s);
        //then
        Assertions.assertEquals("잘못된 입력입니다.", out.toString().trim());
    }

    @Test
    public void EmptyMap_String들어오면_잘못된_입력입니다_출력해야함() {
        //given
        String s = "EmptyMap";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        console.Error(s);
        //then
        Assertions.assertEquals("계산 이력이 존재하지 않습니다.", out.toString().trim());
    }

    @Test
    public void 조회선택시_선택번호_확인용_메시지_나와야함() {
        //given
        int number = 1;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        console.FindAllSelect(number);
        //then
        Assertions.assertEquals(number + " 번을 선택하셨습니다.", out.toString().trim());

    }

    @Test
    public void 계산한_결과값_3이_나와야함() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        console.PrintCalcResult(3L);
        //then
        Assertions.assertEquals("결과 : " + 3L, out.toString().trim());
    }
}
