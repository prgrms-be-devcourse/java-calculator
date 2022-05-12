package com.programmers.java.engine.io;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsoleTest {
	Console console = new Console();

	@Test
	public void Input_String들어오면_잘못된_입력입니다_출력해야함() {
		//given
		String s = "Input";
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		//when
		console.printInfoMessage(s);
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
		console.printInfoMessage(s);
		//then
		Assertions.assertEquals("계산 이력이 존재하지 않습니다.", out.toString().trim());
	}

	@Test
	public void 계산한_결과값_3이_나와야함() {
		//given
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		//when
		console.printCalcResultMessage(3L);
		//then
		Assertions.assertEquals("결과 : " + 3L, out.toString().trim());
	}
}
