package com.programmers.calculator.io;

import java.util.Scanner;

public class Console implements Input, Output{
	private Scanner scanner = new Scanner(System.in);

	@Override
	public String enter() {
		return scanner.next();
	}

	@Override
	public void print(String str) {
		System.out.println(str);
	}
}
