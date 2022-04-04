package hyuk.controller;

import hyuk.calculator.Calculator;
import hyuk.calculator.PostOrderFormula;
import hyuk.calculator.Result;
import hyuk.entity.Record;
import hyuk.model.RecordsDTO;
import hyuk.model.ResultDTO;
import hyuk.repository.Repository;
import hyuk.view.InputView;
import hyuk.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final Repository repository;

    public CalculatorController(InputView inputView, OutputView outputView,
        Calculator calculator, Repository repository) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
        this.repository = repository;
    }

    public void run() {
        while (true) {
            startCalculator();
        }
    }

    private void startCalculator() {
        outputView.printMenu();
        try {
            Menu menu = Menu.of(inputView.selectMenu());
            outputView.printEmptySpace();

            process(menu);
        } catch (Exception e) {
            outputView.printException(e);
        }
    }

    private void process(Menu menu) {
        if (menu.isPrint()) {
            printRecords();
            return;
        }
        calculate();
    }

    private void printRecords() {
        int dataSize = repository.getRecordsSize();
        List<Record> records = new ArrayList<>();
        for (long i = 1; i <= dataSize; ++i) {
            records.add(repository.findById(i));
        }

        outputView.printRecords(new RecordsDTO(records));
    }

    private void calculate() {
        String formula = inputView.inputFormula();

        Result result = calculator.calculates(new PostOrderFormula(formula));
        saveRecord(new Record(formula, result));

        outputView.printResult(new ResultDTO(result));
    }

    private void saveRecord(Record record) {
        repository.store(record);
    }

}
