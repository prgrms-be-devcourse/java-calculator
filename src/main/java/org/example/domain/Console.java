package org.example.domain;

import org.example.domain.Calculator;
import org.example.repository.Records;
import org.example.view.InputView;
import org.example.view.OutputView;
import org.example.view.SelectTypeView;

import static org.example.view.SelectTypeView.GET_LOG;

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
            outputView.start();
            String option = inputView.selectWorks();
            if (option == null) {
                break;
            }
            SelectTypeView selectType = SelectTypeView.findByNum(option);
            selectOption(selectType);
        }
    }

    public void selectOption(SelectTypeView selectType) {
        if (selectType == GET_LOG) {
            outputView.printRecords(Records.arithmeticRecords);
        } else {
            String infixExpression = inputView.inputExpression();
            double result = calculator.calculate(infixExpression);
            outputView.printResult(result);
            Records.arithmeticRecords.add(infixExpression.toString() + " = " + result);
        }
    }
}
