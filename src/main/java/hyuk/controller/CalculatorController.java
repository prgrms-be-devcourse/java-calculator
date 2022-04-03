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
            outputView.printMenu();
            try {
                Menu menu = Menu.of(inputView.selectMenu());
                outputView.printEmptySpace();

                if (menu.isPrint()) {

                    int dataSize = repository.getRecordsSize();
                    List<Record> records = new ArrayList<>();
                    for (long i = 1; i <= dataSize; ++i) {
                        records.add(repository.findById(i));
                    }

                    outputView.printRecords(new RecordsDTO(records));
                    continue;
                }
                calculate();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
                continue;
            }
        }
    }

    private void calculate() {
        while (true) {
            try {
                String formula = inputView.inputFormula();

                Result result = calculator.calculate(new PostOrderFormula(formula));

                Record record = Record.createRecord(formula, result);
                repository.store(record);

                outputView.printResult(new ResultDTO(result));
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

}
