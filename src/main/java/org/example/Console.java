package org.example;

import org.example.repository.Records;
import org.example.view.InputView;
import org.example.view.OutputView;
import org.example.view.SelectTypeView;

import static org.example.view.SelectTypeView.GET_LOG;

public class Console {

    private InputView inputView;
    private OutputView outputView;
    private Calculator calculator;

    public Console(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            outputView.start();
            Integer option = inputView.selectWorks();
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
