package service;

import creator.CreatorManagement;
import entity.Expression;
import console.Console;

import java.io.IOException;
import java.util.List;

public class ClientService{

    private Console console;
    private final CalculatorService calcService = CreatorManagement.getCalcService();

    public ClientService() {
        this.console = new Console();
    }

    public void run() throws IOException {

        boolean isRunning = true;

        while (isRunning) {

            console.printPrompt();

            String cmdInput = console.input();
            console.printNewLine();

            if(!cmdInput.chars().allMatch(Character::isDigit)) {
                console.printCmdFormatError();
                continue;
            }

            int cmd = Integer.parseInt(cmdInput);

            switch (cmd) {

                case 0: // 0. 종료
                    isRunning = false;
                    console.printExitCall();
                    break;

                case 1: // 1. 조회
                    List<Expression> histories = calcService.getHistory();

                    if (histories.size() == 0)
                        console.printHistoryEmptyError();
                    else
                        console.printAllHistories(histories);
                    break;

                case 2: // 2. 계산
                    String input = console.input();
                    
                    if(!input.matches("^-?[0-9]+(\\s+[-+/*]\\s+-?[0-9]+)+")){
                        console.printExpressionError();
                        continue;
                    }
                    
                    double result = calcService.getResult(input);
                    console.printResultNum(result);
                    calcService.saveInput(input, result);
                    break;

                default:
                    console.printCmdTypeError();
                    break;
            }

        }
    }
}
