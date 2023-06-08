package org.example.io;

import org.example.calculation.Calculation;

import java.io.IOException;

public class IoManager {
    private Calculation calculation;
    private Input input;
    private Output output;

    public IoManager(Calculation calculation, Input input, Output output) {
        this.calculation = calculation;
        this.input = input;
        this.output = output;
    }

    public void run() throws Exception{
        while (true){
            output.printAction("1.조회");
            output.printAction("2.계산");

            String action = input.selectAction();
            String curInput;
            if(action.equals("2")) {
                curInput = input.input();
                int resultNnm = calculation.run(curInput);
                output.printCaculatedResult(resultNnm);
                String resultStr = curInput + " = " + String.valueOf(resultNnm);

            } else if (action.equals("1")){

            }else if (action.equals("3")){
                break;
            }else {
                output.printAction("다시 입력해 주세요.");
            }
        }

    }
}
