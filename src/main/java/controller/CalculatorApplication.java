package controller;


import exception.CalculatorException;
import model.Calculator;
import repository.CalculateLogRepository;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;


public class CalculatorApplication {
    private final Calculator calculator;
    private final CalculateLogRepository repository;
    private boolean runFlag;

    public CalculatorApplication(Calculator calculator, CalculateLogRepository repository) {
        this.calculator = calculator;
        this.repository = repository;
        this.runFlag = true;
    }

    public void run() throws InputMismatchException, CalculatorException {
        while (isAppOn()) {
            OutputView.printSelectMenu();
            switch (InputView.selectMenuInput()) {
                case CHECK -> repository.lookupLog(); //기록조회작업 => repository 객체에게 책임 위임
                case CALCULATE -> {
                    String expression = InputView.formulaInput();
                    //todo: Expression.from(expression) 를 통해 클래스를 생성하고 유효한 formula 가 아니라면 isValid() 메서드를 통해 예외처리
                    calculator.calculate(); //계산작업 => calculator 객체에게 책임 위임
                }
                case END ->  {
                    InputView.closeScanner();
                    appOff();
                }
            }
        }
    }

    private boolean isAppOn() {
        return runFlag;
    }

    private void appOff() {
        //todo: app off message insert
        this.runFlag = false;
    }
}
