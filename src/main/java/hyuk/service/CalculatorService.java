package hyuk.service;

import hyuk.calculator.Calculator;
import hyuk.calculator.PostOrderFormula;
import hyuk.calculator.Result;
import hyuk.entity.Record;
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
        PostOrderFormula postOrderFormula = new PostOrderFormula(formula);
        Result result = calculator.calculate(postOrderFormula);

        Record log = Record.createLog(formula, result);
        repository.store(log);

        return new ResultDTO(result);
    }

    public LogDTO printLogs() {
        return new LogDTO(repository.getData());
    }
}
