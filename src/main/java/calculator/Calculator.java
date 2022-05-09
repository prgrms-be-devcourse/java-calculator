package calculator;

import calculator.module.history.CalculationHistory;
import calculator.module.history.CalculationHistoryManager;
import calculator.module.ui.UserInterface;
import calculator.module.validator.exception.InvalidExpressionException;

/**
 * Calculator 설명
 * 문자열 수식을 입력받아 계산해주는 클래스
 * <p>
 * 기능
 * 1. 개산 내역 조회
 *    - 현재까지 계산한 모든 내역을 확인 가능  -> CalculationHistoryManager 클래스에 위임
 * 2. 문자열 수식 계산
 *    - 문자열 수식을 입력받아 계산 -> CalculationProcessor 클래스에 위임
 *    - 계산 결과를 메모리에 저장 -> CalculationHistoryManager 클래스에 위임
 *    - 계산 결과를 화면에 출력 -> UserInterface 클래스에 위임
 **/

public class Calculator {
    private static final String CALCULATION_GUILD_MESSAGE = "계산 수식을 입력하세요. 연산자(괄호 포함)와 숫자는 반드시 공백으로 구분해주세요.";
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
                    doCalculate();
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

    private void doCalculate() {
        userInterface.printMessage(CALCULATION_GUILD_MESSAGE);
        String userInput = userInterface.inputString();
        try {
            Double result = calculationProcessor.startCalculateProcess(userInput);
            loggingCalculationResult(userInput, result);
            userInterface.printMessage(result.toString());
        } catch (InvalidExpressionException e) {
            userInterface.printMessage(e.getMessage());
        }
    }

    private void loggingCalculationResult(String userInput, Double result) {
        CalculationHistory newHistory = new CalculationHistory(userInput, result);
        historyManager.saveCalculationResultToHistory(userInput, newHistory);
    }
}

