package co.programmers.domain;

import co.programmers.exception.ExceptionMessage;
import co.programmers.repository.Repository;
import co.programmers.view.CalculatorOutputView;
import co.programmers.view.InputView;
import co.programmers.view.OutputView;

public class CalculatorApp {

	private final InputView inputView;
	private final OutputView outputView;
	private final Repository repository;

	public CalculatorApp(InputView inputView, OutputView outputView, Repository repository) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.repository = repository;
	}

	public void run() {
		UserMenu userMenu;
		do {
			CalculatorOutputView.printMenuChoiceGuide();
			userMenu = UserMenu.get(inputView.inputUserMenu());
			executeSelectedMenu(userMenu);
		} while (userMenu != UserMenu.TERMINATE);
	}

	private void executeSelectedMenu(UserMenu userMenu) {
		switch (userMenu) {
			case INQUIRY:
				inquiry();
				break;
			case CALCULATE:
				calculate();
				break;
			case TERMINATE:
				break;
			default:
				outputView.printMessage(ExceptionMessage.INVALID_INPUT);
				break;
		}
	}

	public void inquiry() {
		outputView.printCalculationHistory(repository.read());
	}

	public void calculate() {
		try {
			CalculatorOutputView.printCalculationGuide();
			Expression expression = inputView.inputExpression();
			Calculation calculator = new Calculation(expression);
			Double output = calculator.calculate();
			outputView.printCalculationResult(output);
			repository.save(expression.getExpression(), output);
		} catch (ArithmeticException arithmeticException) {
			System.out.println(arithmeticException.getMessage());
		}
	}
}
