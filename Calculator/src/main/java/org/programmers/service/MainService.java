package org.programmers.service;

import lombok.AllArgsConstructor;
import org.programmers.service.IO.Input;
import org.programmers.service.IO.Output;

import java.util.regex.Pattern;

@AllArgsConstructor
public class MainService implements Runnable {
    CalculateService calculateService;
    Input input;
    Output output;

    @Override
    public void run() {

        while (true) {
            output.printMenu();

            String inputNum = input.selectFuction("선택 : ");

            if (inputNum.equals("1")) output.historyInquiry(calculateService.findHistory());

            else if (inputNum.equals("2")){
                String inputEx = input.inputExpression();

                if(!check(inputEx)){
                    output.inputExError();
                    continue;
                }

                output.printResult(calculateService.calculateSave(inputEx));;
            }else{
                output.inputNumError();
            }
        }
    }

    private boolean check(String inputEx) {
        String pattern = "^-?\\d+([ \\t]+[-+/*][ \\t]+\\d+)*";
        return Pattern.matches(pattern, inputEx);
    }
}
