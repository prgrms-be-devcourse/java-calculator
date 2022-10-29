package calculator.factory;

import calculator.io.Console;
import calculator.io.Input;
import calculator.io.Output;
import calculator.operation.Operation;
import calculator.operation.PostfixOperation;
import calculator.parse.Parse;
import calculator.parse.StringParse;
import calculator.repository.FormulaResult;
import calculator.repository.Repository;
import calculator.repository.ResultRepository;
import calculator.validator.FormulaValidator;
import calculator.validator.Validator;

public class ConsoleCalculatorFactory implements CalculatorFactory<FormulaResult, String> {

	@Override
	public Input createInput() {
		return new Console();

	}

	@Override
	public Output<FormulaResult> createOutput() {
		return new Console();
	}

	@Override
	public Operation createOperation() {
		return new PostfixOperation(new FormulaValidator());
	}

	@Override
	public Repository<FormulaResult, String> createRepository() {
		return new ResultRepository();
	}

	@Override
	public Validator createValidator() {
		return new FormulaValidator();
	}

	@Override
	public Parse createParse() {
		return new StringParse();
	}
}
