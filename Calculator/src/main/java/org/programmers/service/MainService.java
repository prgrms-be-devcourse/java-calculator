package org.programmers.service;

import lombok.AllArgsConstructor;
import org.programmers.service.IO.Input;
import org.programmers.service.IO.Output;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class MainService implements Runnable {
    private final int ERROR_1 = 1;
    private final int ERROR_2 = 2;
    CalculateService calculateService;
    Input input;
    Output output;

    @Override
    public void run() {

        while (true) {
            output.printMenu();
            String inputNum = input.selectFuction("선택 : ");

            if (inputNum.equals("1")) {
                output.historyInquiry(calculateService.findHistory());
            } else if (inputNum.equals("2")) {
                String inputEx = input.inputExpression();

                if (validCheck(inputEx) == ERROR_1) {
                    output.inputExError(ERROR_1);
                    continue;
                } else if (validCheck(inputEx) == ERROR_2) {
                    output.inputExError(ERROR_2);
                    continue;
                }

                output.printResult(calculateService.calculateSave(inputEx));
                ;
            } else {
                output.inputNumError();
            }
        }
    }

    private int validCheck(String inputEx) {
        String pattern = "^-?(\\d*\\.?\\d+)([ \\t]+[-+/*][ \\t]+(\\d*\\.?\\d+))*";
        Pattern divZero = Pattern.compile("[/][ \\t]0((\\.0+)|$|[ \\t])");
        Matcher m = divZero.matcher(inputEx);

        if (!Pattern.matches(pattern, inputEx)){
            return ERROR_1;
        } else if (m.find()){
            return ERROR_2;
        }
        return 0;
    }
}
