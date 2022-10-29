package calculator.factory;

import calculator.io.Input;
import calculator.io.Output;
import calculator.operation.Operation;
import calculator.parse.Parse;
import calculator.repository.FormulaResult;
import calculator.repository.Repository;
import calculator.validator.Validator;

public interface CalculatorFactory<T extends FormulaResult, U> {
	Input createInput();

	Output<T> createOutput();

	Operation createOperation();

	Repository<T, U> createRepository();

	Validator createValidator();

	Parse createParse();
}
