package calculator.factory;

import calculator.io.Input;
import calculator.io.Output;
import calculator.operation.Operation;
import calculator.parse.Parse;
import calculator.repository.FormulaResult;
import calculator.repository.Repository;
import calculator.validator.Validator;

public interface CalculatorFactory<T extends FormulaResult, ID> {
	Input createInput();

	Output createOutput();

	Operation createOperation();

	Repository<T, ID> createRepository();

	Validator createValidator();

	Parse createParse();
}
