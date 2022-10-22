package calculator.engine.controller;

import calculator.engine.io.Input;
import calculator.engine.io.Output;
import calculator.engine.io.enums.SelectOption;
import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;
import calculator.engine.model.UserSelection;
import calculator.engine.repository.History;

public class Controller implements Runnable{
    private final Input input;
    private final Output output;
    private final Calculator calculator;
//    private final History history;

    public Controller(Calculator calculator, Input input, Output output) {
        this.calculator = calculator;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        while(true) {
            // get user selection
            UserSelection selection = input.getUserSelection(SelectOption.getLiterals());

            // if selection is `calculate`, request expression to customer
            // then calculate expression & record result to history
//            if (selection.isEqualTo(SelectOption.CALCULATE)) {
////                Expression expression = input.getExpression();
////                CalculationResult result = calculator.calculate(expression);
////                hisotry.record(result);
//            }

            // if selection is `QUERY`, request repository to show history
            // prompt all calculation records
//            if (selection.isEqualTo(SelectOption.QUERY)) {
//
//            }

            // if selection is `exit`,
            // prompt exit message end & end loop
//            if (selection.isEqualTo(SelectOption.EXIT)) {
//                // output.prompt(exitMessage);
//                break;
//            }
        }
    }
}
