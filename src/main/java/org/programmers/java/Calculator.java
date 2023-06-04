package org.programmers.java;

import org.programmers.java.console.Input;
import org.programmers.java.console.Output;
import org.programmers.java.message.ErrorMsg;

public class Calculator {
    private boolean exitStatus = true;
    private Input input;
    private Output output;

    Calculator(Input input, Output output){
        this.input = input;
        this.output = output;
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
                    System.out.println("계산기 동작");
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
