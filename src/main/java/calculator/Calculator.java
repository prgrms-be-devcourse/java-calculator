package calculator;

import calculator.module.history.CalculationHistoryManager;
import calculator.module.ui.UserInterface;

/**
 * Calculator 설명
 * 문자열 수식을 입력받아 계산해주는 클래스
 * <p>
 * 기능
 * 1. 개산 내역 조회
 *    - 현재까지 계산한 모든 내역을 확인 가능  -> CalculationHistoryManager 클래스에 위임
 * 2. 문자열 수식 계산
 *    - 문자열 수식을 입력받아 계산 -> CalculationProcessor 클래스에 위임
 **/

public class Calculator {
    private static final String INVALID_COMMAND_OPTION_MESSAGE = "잘못된 명령입니다.";
    private final UserInterface userInterface;
    private final CalculationHistoryManager historyManager;
    private final CalculationProcessor calculationProcessor;

    public Calculator(UserInterface userInterface,
                      CalculationHistoryManager historyManager,
                      CalculationProcessor calculationProcessor) {
        this.userInterface = userInterface;
        this.historyManager = historyManager;
        this.calculationProcessor = calculationProcessor;
    }

    public void run() {
        boolean isUserSelectQuit = false;
        String userInput;
        while (!isUserSelectQuit) {
            userInterface.showMenu();
            userInput = userInterface.inputString();
            CommandOption command = CommandOption.createCommandOption(userInput);
            switch (command) {
                case SHOW_HISTORY:
                    historyManager.printAllCalculationHistory();
                    break;
                case CALCULATION:
                    calculationProcessor.startCalculateProcess();
                    break;
                case QUIT:
                    isUserSelectQuit = true;
                    break;
                default:
                    userInterface.printMessage(INVALID_COMMAND_OPTION_MESSAGE);
                    break;
            }
        }
    }
}

