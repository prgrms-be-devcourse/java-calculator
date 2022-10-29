package calculator;

import calculator.factory.CalculatorFactory;
import calculator.factory.ConsoleCalculatorFactory;

public class Main {

	public static void main(String[] args) {
		CalculatorFactory calculatorFactory = new ConsoleCalculatorFactory();
		Calculator calculator = new PostfixCalculator(calculatorFactory);
		calculator.prepare();
		calculator.run();
	}

}
