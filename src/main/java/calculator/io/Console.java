package calculator.io;

import java.util.List;
import java.util.Scanner;

import calculator.repository.FormulaResult;

public class Console implements Input, Output<FormulaResult> {

	private final Scanner scanner = new Scanner(System.in);

	@Override
	public String input(String s) {
		System.out.println(s);
		return scanner.nextLine();
	}

	@Override
	public void requestInput() {
		System.out.println("1. 조회");
		System.out.println("2. 계산");
		System.out.println("3. 종료");
	}

	@Override
	public void output(String s) {
		System.out.println(s);
	}

	@Override
	public void printFormulas(List<FormulaResult> formulaResults) {
		for (FormulaResult formulaResult : formulaResults) {
			output(formulaResult.toString());
		}
	}

	@Override
	public void printAnswer(FormulaResult formulaResult) {
		output(formulaResult.getAnswer());
	}

}
