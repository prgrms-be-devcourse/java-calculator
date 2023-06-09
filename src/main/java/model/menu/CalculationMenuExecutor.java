package model.menu;

import exception.CalculatorException;
import model.CalculationLog;
import model.MathExpression;
import repository.CalculationLogRepository;

import static view.InputView.mathExpressionInput;
import static view.OutputView.printResult;

public class CalculationMenuExecutor extends SelectMenuExecutor{
    public CalculationMenuExecutor(final int menuNumber, final CalculationLogRepository clrp) {
        super(menuNumber, clrp);
    }

    @Override
    public void execute() throws CalculatorException {
        String userExpressionInput = mathExpressionInput();
        MathExpression me = MathExpression.from(userExpressionInput);
        int result = me.calculate();
        printResult(result);
        CalculationLog cl = CalculationLog.of(userExpressionInput, result);
        clrp.save(cl);
    }
}
