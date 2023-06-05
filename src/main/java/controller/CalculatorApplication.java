package controller;


import exception.CalculatorException;
import controller.dto.MathExpression;
import model.CalculationLog;
import model.calculator.Calculator;
import repository.CalculationLogRepository;

import static view.InputView.*;
import static view.OutputView.*;


public class CalculatorApplication {
    private final Calculator calculator;
    private final CalculationLogRepository clrp;
    private boolean runFlag;

    public CalculatorApplication(final Calculator calculator, final CalculationLogRepository clrp) {
        this.calculator = calculator;
        this.clrp = clrp;
        this.runFlag = true;
    }

    public void run() throws CalculatorException {
        while (isAppTurnOn()) {
            printSelectMenu();
            switch (selectMenuInput()) {
                case CHECK -> clrp.viewLog();
                case CALCULATE -> {
                    String userExpressionInput = mathExpressionInput();
                    MathExpression me = MathExpression.from(userExpressionInput);
                    int result = calculator.calculate(me);
                    printResult(result);
                    CalculationLog cl = CalculationLog.of(userExpressionInput, result);
                    clrp.save(cl);
                }
                case END ->  {
                    inputClose();
                    appTurnOff();
                }
            }
        }
    }

    private boolean isAppTurnOn() {
        return runFlag;
    }

    private void appTurnOff() {
        printTurnOff();
        this.runFlag = false;
    }
}
