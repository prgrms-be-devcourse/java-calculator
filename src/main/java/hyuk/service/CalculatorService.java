package hyuk.service;

import hyuk.calculator.Calculator;
import hyuk.calculator.PostOrderFormula;
import hyuk.calculator.Result;
import hyuk.entity.Record;
import hyuk.model.RecordsDTO;
import hyuk.model.ResultDTO;
import hyuk.repository.Repository;
import java.util.ArrayList;
import java.util.List;

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

        Record record = Record.createRecord(formula, result);
        repository.store(record);

        return new ResultDTO(result);
    }

    public RecordsDTO printRecords() {
        int dataSize = repository.getRecordsSize();
        List<Record> records = new ArrayList<>();
        for (long i = 1; i <= dataSize; ++i) {
            records.add(repository.findById(i));
        }

        return new RecordsDTO(records);
    }
}
