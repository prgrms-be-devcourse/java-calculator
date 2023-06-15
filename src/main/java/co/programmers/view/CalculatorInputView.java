package co.programmers.view;

import java.util.Scanner;

import co.programmers.domain.Expression;

public class CalculatorInputView implements InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	@Override
	public Integer inputUserMenu() {
		Integer userInput = SCANNER.nextInt();
		SCANNER.nextLine();
		return userInput;
	}

	@Override
	public Expression inputExpression() throws ArithmeticException {
		return new Expression(SCANNER.nextLine());
	}
}
