package com.programmers.java.engine.io;

import java.util.List;
import java.util.Scanner;

import com.programmers.java.engine.model.FormulaAndResult;

public class Console implements Input, Output {
	private final Scanner sc = new Scanner(System.in);

	@Override
	public String input(String s) {
		System.out.println(s);
		System.out.print("입력 : ");

		return sc.nextLine();
	}

	@Override
	public void printInfoMessage(String s) {
		System.out.println(s);
	}

	@Override
	public void printCalcResultMessage(Long result) {
		System.out.println("결과 : " + result + "\n");
	}

	@Override
	public void printHistory(List<FormulaAndResult> histories) {
		for (Object history : histories) {
			System.out.println(history);
		}
	}
}
