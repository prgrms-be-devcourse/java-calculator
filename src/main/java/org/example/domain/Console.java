package org.example.domain;

import org.example.repository.Records;
import org.example.view.SelectTypeView;
import org.example.view.View;
import java.util.Optional;

public class Console {

    private View view;
    private Calculator calculator;
    private Records records;
    private boolean calculatorProcess = true;

    public Console(View view, Calculator calculator,Records records) {
        this.view = view;
        this.calculator = calculator;
        this.records = records;
    }

    public void run() {
        while (calculatorProcess) {
            view.printSelection();
            SelectTypeView selectType = view.select();
            selectOption(selectType);
        }
    }

    private void selectOption(SelectTypeView selectType) {
        switch (selectType) {
            case GET_RECORD -> view.printRecords(records.exportRecord());

            case CALCULATE -> {
                String infixExpression = view.inputExpression();
                double result = calculator.calculate(infixExpression);
                view.printResult(result);
                records.saveRecord(infixExpression, result);
            }

            case END -> calculatorProcess = false;
        }
    }
}
