package org.example.domain;

import org.example.repository.Records;
import org.example.view.InputView;
import org.example.view.OutputView;
import org.example.view.SelectTypeView;

public class Console {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public Console(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            outputView.printSelection();
            String option = inputView.selectWork();
            SelectTypeView selectType = SelectTypeView.findByNum(option);
            selectOption(selectType);
        }
    }

    public void selectOption(SelectTypeView selectType) {

        switch (selectType) {

            case GET_RECORD -> outputView.printRecords(Records.exportRecord());

            case CALCULATE -> {
                String infixExpression = inputView.inputExpression();
                double result = calculator.calculate(infixExpression);
                outputView.printResult(result);
                Records.saveRecord(infixExpression, result);
            }
        }
    }
}
