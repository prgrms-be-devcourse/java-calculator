package calculator;

import java.util.List;

import calculator.factory.CalculatorFactory;
import calculator.repository.FormulaResult;

public class PostfixCalculator extends Calculator implements Runnable {

	CalculatorFactory calculatorFactory;

	public PostfixCalculator(CalculatorFactory calculatorFactory) {
		this.calculatorFactory = calculatorFactory;
	}

	@Override
	void prepare() {
		input = calculatorFactory.createInput();
		output = calculatorFactory.createOutput();
		operation = calculatorFactory.createOperation();
		repository = calculatorFactory.createRepository();
		parse = calculatorFactory.createParse();
		validator = calculatorFactory.createValidator();
	}

	@Override
	public void run() {
		while (true) {
			output.requestInput();
			Menu menu = Menu.getOrder(input.input("선택 : "));
			if (selectMenu(menu))
				return;

		}
	}

	private boolean selectMenu(Menu menu) {
		switch (menu) {
			case PRINT_FORMULAS:
				printFormulas(repository.findAll());
				break;
			case CALCULATE:
				String s = parse.parseBlank(input.input("수식을 입력하세요"));
				if (checkFormula(s)) {
					output.output("잘못된 수식입니다.");
					break;
				}
				calculateFormula(s);
				break;
			case EXIT:
				output.output("종료합니다.");
				return true;
			default:
				output.output("잘 못 입력했어요");

		}
		return false;
	}

	private boolean checkFormula(String s) {
		return !validator.isFormula(s) || validator.isDivideZero(s);
	}

	private void printFormulas(List<FormulaResult> formulaResults) {
		output.printFormulas(formulaResults);
	}

	private void calculateFormula(String formula) {
		FormulaResult formulaResult = repository.findOne(formula)
			.orElseGet(() -> calculate(formula, parse.toList(formula)));
		output.printAnswer(formulaResult);

	}

	private FormulaResult calculate(String formula, List<String> tokens) {
		String answer = operation.calculate(tokens);
		FormulaResult formulaResult = new FormulaResult(formula, answer);
		repository.save(formulaResult);
		return formulaResult;
	}

}
