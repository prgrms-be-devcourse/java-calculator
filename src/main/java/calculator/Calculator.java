package calculator;

import java.util.List;

import calculator.io.Input;
import calculator.io.Output;
import calculator.operation.Service;
import calculator.parse.Parse;
import calculator.repository.Repository;
import calculator.validator.Validator;

public class Calculator implements Runnable {

	private static final String PRINT_FORMULAS = "1";
	private static final String CALCULATE = "2";
	private static final String EXIT = "3";

	Input input;
	Output output;
	Service service;
	Repository repository;
	Parse parse;
	Validator validator;

	public Calculator(Input input, Output output, Service service, Repository repository, Parse parse,
		Validator validator) {
		this.input = input;
		this.output = output;
		this.service = service;
		this.repository = repository;
		this.parse = parse;
		this.validator = validator;
	}

	@Override
	public void run() {
		while (true) {
			output.requestInput();
			switch (input.inputOrder()) {
				case PRINT_FORMULAS:
					printFormulas();
					break;
				case CALCULATE:
					calculate();
					break;
				case EXIT:
					exit();
					return;
				default:
					output.printWrongOrder();

			}

		}
	}

	private void printFormulas() {
		List<String> list = repository.findAll();
		if (list.isEmpty()) {
			output.printNoData();
		} else {
			output.printFormulas(list);
		}
	}

	private void calculate() {

		String formula = parse.parse(input.inputFormula());
		if (!validator.isFormula(formula)) {
			output.printWrongFormula();
			return;
		}

		if (repository.isExist(formula)) {
			output.printAnswer(repository.find(formula));
		} else {
			List<String> tokens = parse.toList(formula);
			List<String> postFix = service.toPostFix(tokens);

			try {
				String result = service.calculate(postFix);
				repository.save(formula, result);
				output.printAnswer(result);
			} catch (Exception e) {
				output.printDivideZero();
			}

		}
	}

	private void exit() {
		output.printExit();
	}

}
