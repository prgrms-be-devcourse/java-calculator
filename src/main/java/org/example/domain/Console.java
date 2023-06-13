package org.example.domain;

import org.example.repository.Records;
import org.example.view.SelectTypeView;
import org.example.view.View;

public class Console {

    private View view;
    private Calculator calculator;
    private static boolean loop = false;

    public Console(View view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void run() {
        while (!loop) {
            view.printSelection();
            String option = view.selectWork();
            SelectTypeView selectType = SelectTypeView.findByNum(option);
            selectOption(selectType);
        }

    }

    private void selectOption(SelectTypeView selectType) {
        switch (selectType) {
            case GET_RECORD -> view.printRecords(Records.exportRecord());

            case CALCULATE -> {
                String infixExpression = view.inputExpression();
                double result = calculator.calculate(infixExpression);
                view.printResult(result);
                Records.saveRecord(infixExpression, result);
            }

            case END -> loop = true;
        }
    }


}
