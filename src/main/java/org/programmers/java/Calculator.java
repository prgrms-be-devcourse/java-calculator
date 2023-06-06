package org.programmers.java;

import org.programmers.java.calculate.Calculate;
import org.programmers.java.console.Input;
import org.programmers.java.console.Output;
import org.programmers.java.message.ErrorMsg;

public class Calculator {
    private boolean exitStatus = true;
    private final Input input;
    private final Output output;
    private final Calculate calculate;

    Calculator(Input input, Output output, Calculate calculate){
        this.input = input;
        this.output = output;
        this.calculate = calculate;
    }

    void run() {
        while (exitStatus) {
            output.menuMsg();
            String inputNum = input.numInput();
            output.selectMsg(inputNum);
            switch (inputNum) {
                case "1":
                    break;
                case "2":
                    String formula = input.calculationInput();
                    if(formula.equals("")) break;
                    String result = calculate.requestCalculate(formula);
                    output.calculationValue(result);
                    break;
                case "3":
                    output.exitMsg();
                    exitStatus = false;
                    break;
                default:
                    System.out.println(ErrorMsg.SELECT_VALIDATION_ERROR_MSG.getErrorMsg());
            }
        }
    }
}
