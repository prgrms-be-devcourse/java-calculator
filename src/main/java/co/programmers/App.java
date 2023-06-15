package co.programmers;

import co.programmers.domain.CalculatorApp;
import co.programmers.view.CalculatorInputView;
import co.programmers.view.CalculatorOutputView;
import co.programmers.view.InputView;
import co.programmers.view.OutputView;

public class App {

	public static void main(String[] args) {
		InputView inputView = new CalculatorInputView();
		OutputView outputView = new CalculatorOutputView();
		CalculatorApp calculatorApp = new CalculatorApp(inputView, outputView);
		calculatorApp.run();
	}
}
