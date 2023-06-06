package controller;


import exception.CalculatorException;
import model.vo.MathExpression;
import model.CalculationLog;
import model.service.CalculateService;
import repository.CalculationLogRepository;

import static view.InputView.*;
import static view.OutputView.*;


public class CalculatorApplication {
    private final CalculateService calculateService;
    private final CalculationLogRepository clrp;
    private boolean runFlag;

    public CalculatorApplication(final CalculateService calculateService, final CalculationLogRepository clrp) {
        this.calculateService = calculateService;
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
                    int result = calculateService.calculate(me);
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
