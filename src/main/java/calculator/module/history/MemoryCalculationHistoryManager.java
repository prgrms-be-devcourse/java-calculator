package calculator.module.history;

import calculator.module.ui.UserInterface;

import java.util.HashMap;
import java.util.Map;

/**
*
* MemoryCalculationHistoryManager 설명
*   계산 이력 조회 기능을 담당하는 클래스
**/
public class MemoryCalculationHistoryManager implements CalculationHistoryManager {
    private final Map<String,CalculationHistory> calculationHistoryStore;
    private final static String HISTORY_NOT_EXIST_MESSAGE = "계산 이력이 없습니다.";
    private final UserInterface userInterface;

    public MemoryCalculationHistoryManager(UserInterface userInterface){
        this.userInterface = userInterface;
        calculationHistoryStore = new HashMap<>();
    }

    @Override
    public void printAllCalculationHistory() {
        if(calculationHistoryNotExist()){
            userInterface.printMessage(HISTORY_NOT_EXIST_MESSAGE);
        }
        else {
            printHistory();
        }
    }

    @Override
    public void saveCalculationResultToHistory(String expression, CalculationHistory history) {
        calculationHistoryStore.put(expression,history);
    }

    public CalculationHistory findCalculationHistoryByExpression(String expression){
        return calculationHistoryStore.get(expression);
    }

    public boolean calculationHistoryNotExist(){
        return calculationHistoryStore.isEmpty();
    }

    private void printHistory(){
        calculationHistoryStore.forEach((expression,calculationHistory) -> {
            userInterface.printMessage(calculationHistory.toString());
        });
    }

}
