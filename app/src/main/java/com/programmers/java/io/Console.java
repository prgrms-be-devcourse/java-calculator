package com.programmers.java.io;

import java.util.List;
import java.util.Scanner;

import com.programmers.java.model.History;

public class Console implements Input, Output {
	private final Scanner scanner = new Scanner(System.in);

	@Override
	public String inputMenuNumber() {
		String chosenNumber = scanner.nextLine();
		System.out.println();
		return chosenNumber;
	}

	@Override
	public String inputFormula() {
		String formula = scanner.nextLine().replaceAll(" ", "");
		return formula;
	}

	@Override
	public void printMenu(String menu) {
		System.out.print(menu);
	}

	@Override
	public void printHistory(List<History> history) {
		history.forEach(i -> System.out.println(i.getHistory()));
		System.out.println();
	}

	@Override
	public void printFormulaResult(int result) {
		System.out.println(result);
		System.out.println();
	}

	@Override
	public void printExit(String exitMessage) {
		System.out.println(exitMessage);
	}

	@Override
	public void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
		System.out.println();
	}
}
