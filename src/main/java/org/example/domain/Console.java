package org.example.domain;

import org.example.repository.Records;
import org.example.view.SelectTypeView;
import org.example.view.View;
import java.util.Optional;

public class Console {

    private View view;
    private Calculator calculator;
    private Records records;
    private boolean calculatorProcess = false;

    public Console(View view, Calculator calculator,Records records) {
        this.view = view;
        this.calculator = calculator;
        this.records = records;
    }

    public void run() {
        while (!calculatorProcess) {
            view.printSelection();
            int option = view.select();
            Optional<SelectTypeView> selectType = SelectTypeView.findByNum(option);
            selectOption(selectType);
        }
    }

    private void selectOption(Optional<SelectTypeView> selectType) {
        selectType.ifPresentOrElse(
            type -> {
            switch (type) {
                case GET_RECORD -> view.printRecords(records.exportRecord());

                case CALCULATE -> {
                    String infixExpression = view.inputExpression();
                    double result = calculator.calculate(infixExpression);
                    view.printResult(result);
                    records.saveRecord(infixExpression, result);
                }

                case END -> calculatorProcess = true;
                }
            },
            () -> {throw new IllegalArgumentException("잘못된 입력입니다.");}
        );
    }


}
