package calculator;

import calculator.controller.Calculator;
import calculator.filter.FilterImpl;
import calculator.io.Input;
import calculator.io.Output;
import calculator.model.HistoryImpl;
import calculator.operator.OperateManager;

public class Application {
    public static void main(String[] args) {
        new Calculator(new Input(), new Output(), new HistoryImpl(), new OperateManager(), new FilterImpl()).run();
    }
}
