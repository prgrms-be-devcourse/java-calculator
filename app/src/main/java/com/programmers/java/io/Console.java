package com.programmers.java.io;

import java.util.List;
import java.util.Scanner;

import com.programmers.java.model.History;

public class Console implements Input, Output {
	private final Scanner scanner = new Scanner(System.in);

	@Override
	public String read() {
		return scanner.nextLine();
	}

	@Override
	public void write(String value) {
		System.out.println(value);
	}

	@Override
	public void writeResult(int result) {
		System.out.println(result);
		System.out.println();
	}

	@Override
	public void writeAllHistory(List<History> history) {
		history.forEach(i -> System.out.println(i.toString()));
		System.out.println();
	}
}
