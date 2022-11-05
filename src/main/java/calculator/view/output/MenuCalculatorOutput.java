package calculator.view.output;

import calculator.calculator.history.CalculationHistoryForm;

import static calculator.view.output.TextUnit.ENTER;

public class MenuCalculatorOutput implements BaseOutput {

    public void printAnswer(CalculationHistoryForm calculationHistoryForm) {
        print(calculationHistoryForm
                .getCalculationResult()
                .getResult()
                + ENTER.getUnit()
                + ENTER.getUnit());
    }

}
