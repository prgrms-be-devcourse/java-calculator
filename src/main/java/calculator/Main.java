package calculator;

import calculator.factory.CalculatorFactory;
import calculator.factory.ConsoleCalculatorFactory;
import calculator.repository.FormulaResult;

public class Main {

	public static void main(String[] args) {
		CalculatorFactory<FormulaResult, String> calculatorFactory = new ConsoleCalculatorFactory();
		Calculator calculator = new PostfixCalculator(calculatorFactory);
		calculator.prepare();
		calculator.run();
	}

}
