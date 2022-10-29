package calculator;

import calculator.io.Input;
import calculator.io.Output;
import calculator.operation.Operation;
import calculator.parse.Parse;
import calculator.repository.FormulaResult;
import calculator.repository.Repository;
import calculator.validator.Validator;

public abstract class Calculator implements Runnable {
	Input input;
	Output output;
	Operation operation;
	Repository<FormulaResult, String> repository;
	Validator validator;
	Parse parse;

	abstract void prepare();
}
