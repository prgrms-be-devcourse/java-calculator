package calculator;

import calculator.io.IOManager;
import calculator.operation.OperationManager;
import calculator.parse.StringParse;
import calculator.repository.ResultRepository;
import calculator.validator.FormulaValidator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new IOManager(),
                new IOManager(),
                new OperationManager(new FormulaValidator()),
                ResultRepository.REPOSITORY,
                new StringParse(),
                new FormulaValidator());
        calculator.run();
    }
}
