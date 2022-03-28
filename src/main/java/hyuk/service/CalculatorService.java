package hyuk.service;

import hyuk.calculator.Calculator;
import hyuk.calculator.Operands;
import hyuk.calculator.Operators;
import hyuk.calculator.Result;
import hyuk.entity.Log;
import hyuk.model.LogDTO;
import hyuk.model.ResultDTO;
import hyuk.repository.Repository;

public class CalculatorService {

    private final Repository repository;
    private final Calculator calculator;

    public CalculatorService(Repository repository, Calculator calculator) {
        this.repository = repository;
        this.calculator = calculator;
    }

    public ResultDTO calculate(String formula) {
        Operands operands = new Operands(formula);
        Operators operators = new Operators(formula);
        Result result = calculator.calculate(operands, operators);

        Log log = Log.createLog(operands, operators, result);
        repository.store(log);

        return new ResultDTO(result);
    }

    public LogDTO printLogs() {
        return new LogDTO(repository.getData());
    }
}
