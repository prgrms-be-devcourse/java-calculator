package calculator;

import calculator.model.expression.Expression;
import calculator.model.expression.ExpressionFactory;
import calculator.module.arithmetic.ArithmeticModule;
import calculator.module.history.CalculationHistory;
import calculator.module.history.CalculationHistoryManager;
import calculator.module.ui.UserInterface;
import calculator.module.validator.ExpressionValidator;
import calculator.module.validator.exception.InvalidExpressionException;
/**
*
* Calculator 설명
* 문자열 수식을 입력받아 계산해주는 클래스
 *
 * 기능
 * 1. 개산 내역 조회
 *    - 현재까지 계산한 모든 내역을 확인 가능  -> CalculationHistoryManager 클래스에 위임
 * 2. 문자열 수식 계산
 *    - 원시 문자열로 구성된 수식이 유효한 수식인지 검증 -> ExpressionValidator 클래스에 위임
 *    - 검증된 문자열 수식 계산 -> ArithmeticModule 클래스에 위임
**/

public class Calculator {
    private static final String INVALID_COMMAND_OPTION_MESSAGE ="잘못된 명령입니다.";
    private static final String CALCULATION_GUILD_MESSAGE ="계산 수식을 입력하세요. 연산자(괄호 포함)와 숫자는 반드시 공백으로 구분해주세요.";
    private static final String SHOW_HISTORY = "1";
    private static final String CALCULATE = "2";
    private static final String QUIT = "3";

    private final CalculationHistoryManager calculationHistoryManager;
    private final ArithmeticModule arithmeticModule;
    private final ExpressionValidator expressionValidator;
    private final UserInterface userInterface;
    private final ExpressionFactory expressionFactory;

    public Calculator(CalculationHistoryManager calculationHistoryManager,
                      ArithmeticModule arithmeticModule,
                      ExpressionValidator expressionValidator,
                      UserInterface userInterface,
                      ExpressionFactory expressionFactory){
        this.calculationHistoryManager = calculationHistoryManager;
        this.arithmeticModule = arithmeticModule;
        this.expressionValidator = expressionValidator;
        this.userInterface = userInterface;
        this.expressionFactory = expressionFactory;
    }

    public void run(){
        boolean isUserSelectQuit = false;
        String commandOption;
        while(!isUserSelectQuit){
            userInterface.showMenu();
            commandOption = userInterface.inputString();
            switch (commandOption){
                case SHOW_HISTORY:
                    calculationHistoryManager.printAllCalculationHistory();
                    break;
                case CALCULATE :
                    startCalculateProcess();
                    break;
                case QUIT :
                    isUserSelectQuit = true;
                    break;
                default :
                    printInvalidCommandOptionSelectedMessage();
                    break;
            }
        }
    }

    private void startCalculateProcess(){
        userInterface.printMessage(CALCULATION_GUILD_MESSAGE);
        String userInput = userInterface.inputString();
        try{
            Expression expression = expressionFactory.createExpression(userInput);
            expressionValidator.validateExpression(expression);
            Double calculationResult = arithmeticModule.calculate(expression);
            CalculationHistory newHistory = new CalculationHistory(userInput,calculationResult);
            calculationHistoryManager.saveCalculationResultToHistory(userInput,newHistory);
            userInterface.printMessage(calculationResult.toString());
        }catch (InvalidExpressionException e) {
            userInterface.printMessage(e.getMessage());
        }
    }

    private void printInvalidCommandOptionSelectedMessage(){
        userInterface.printMessage(INVALID_COMMAND_OPTION_MESSAGE);
    }
}

